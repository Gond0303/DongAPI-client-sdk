package com.dong.dongapiclientsdk.service;

import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.dong.dongapiclientsdk.client.DongApiClient;
import com.dong.dongapiclientsdk.exception.ApiException;
import com.dong.dongapiclientsdk.exception.ErrorCode;
import com.dong.dongapiclientsdk.exception.ErrorResponse;
import com.dong.dongapiclientsdk.model.request.BaseRequest;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import com.dong.dongapiclientsdk.utils.SignUtils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

@Data
@Slf4j
public abstract class BaseService implements ApiService{
    private DongApiClient dongApiClient;

    /**
     * 网关HOST
     */
    private String getewayHost = "http://localhost:8090/api";



    /**
     * 获取响应数据
     *
     * @param request 要求
     * @return {@link T}
     * @throws ApiException 业务异常
     */
    // 定义一个泛型方法res，接收一个BaseRequest<O, T>类型的参数request，其中O是任意类型，T是ResultResponse的子类型。
    // 方法返回T类型的结果，并可能抛出ApiException异常。
    public <O, T extends ResultResponse> T res(BaseRequest<O, T> request) throws ApiException {
        // 检查dongApiClient是否为null，或者AccessKey/SecretKey是否为空。
        if (dongApiClient == null || StringUtils.isAnyBlank(dongApiClient.getAccessKey(), dongApiClient.getSecretKey())) {
            throw new ApiException(ErrorCode.NO_AUTH_ERROR, "请先配置密钥AccessKey/SecretKey");
        }

        log.info("【dongApiClient客户端信息】：【accessKey】：{},【secretKey】："+dongApiClient.getAccessKey(),dongApiClient.getSecretKey());

        T rsp; // 声明一个T类型的变量rsp，用于存储响应对象。

        try {
            // 获取请求对应的响应类类型。
            Class<T> clazz = request.getResponseClass();
            // 使用反射创建该类型的实例。注意：这里可能抛出InstantiationException, IllegalAccessException等异常。
            rsp = clazz.newInstance();
        } catch (Exception e) {
            // 如果在创建实例过程中发生异常，则抛出ApiException，错误码为OPERATION_ERROR，并附上异常信息。
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }

        // 发送请求到服务器，获取HttpResponse对象。
        HttpResponse httpResponse = doRequest(request);

        // 从HttpResponse中获取响应体内容。
        String body = httpResponse.body();

        // 创建一个HashMap来存储响应数据。
        Map<String, Object> data = new HashMap<>();


        // 检查HTTP响应状态码是否为200（表示成功）。
        if (httpResponse.getStatus() != 200) {
            // 如果不是200，则尝试将响应体解析为ErrorResponse对象。
            ErrorResponse errorResponse = JSONUtil.toBean(body, ErrorResponse.class);
            // 将错误信息和错误码存入data中。
            data.put("errorMessage", errorResponse.getMessage());
            data.put("code", errorResponse.getCode());
        } else {
            try {
                // 尝试使用Gson将响应体解析为Map<String, Object>类型的JSON对象。
                data = new Gson().fromJson(body, new TypeToken<Map<String, Object>>() {}.getType());
            } catch (JsonSyntaxException e) {
                // 如果解析失败（比如响应体不是有效的JSON），则将响应体作为普通字符串存储在data中。
                data.put("value", body);
            }
        }

        // 将解析得到的响应数据设置到之前创建的响应对象rsp中。
        // 假设T类型（即ResultResponse的子类型）有一个setData方法用于设置数据。
        rsp.setData(data);

        // 返回填充了数据的响应对象。
        return rsp;
    }


    /**
     * 检查配置
     * @param dongApiClient dong api 客户端
     * @throws ApiException 业务异常
     */
    public void checkConfig(DongApiClient dongApiClient) throws ApiException {
        if (dongApiClient == null && this.getDongApiClient() == null){
            throw new ApiException(ErrorCode.NO_AUTH_ERROR,"请先配置密钥AccessKey和SecretKey");
        }
        if (dongApiClient != null && !StringUtils.isAnyBlank(dongApiClient.getAccessKey(), dongApiClient.getSecretKey())){
            this.setDongApiClient(dongApiClient);
        }
    }


    /**
     * 执行请求
     *
     * @param request 请求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    private <O, T extends ResultResponse> HttpResponse doRequest(BaseRequest<O, T> request) throws ApiException {
        try  {
            HttpResponse httpResponse = getHttpRequestByRequestMethod(request).execute();
            return httpResponse;
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    /**
     * 通过请求方法获取http响应
     *
     * @param request 要求
     * @return {@link HttpResponse}
     * @throws ApiException 业务异常
     */
    private <O, T extends ResultResponse> HttpRequest getHttpRequestByRequestMethod(BaseRequest<O, T> request) throws ApiException {
        if (ObjectUtils.isEmpty(request)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求参数错误");
        }
        String path = request.getPath().trim();
        String method = request.getMethod().trim().toUpperCase();

        if (ObjectUtils.isEmpty(method)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求方法不存在");
        }
        if (StringUtils.isBlank(path)) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, "请求路径不存在");
        }
        //1.路径开头是否是网关路径开头的
        if (path.startsWith(getewayHost)) {
            //取网关地址的后缀/XXX
            path = path.substring(getewayHost.length());
        }

        log.info("请求方法：{}，请求路径网关的后缀：{}，请求参数：{}", method, path, request.getRequestParams());
        HttpRequest httpRequest;
        //判断请求类型，拼接HttpRequest对象
        switch (method) {
            case "GET": {
                httpRequest = HttpRequest.get(splicingGetRequest(request, path));
                break;
            }
            case "POST": {
                httpRequest = HttpRequest.post(getewayHost + path);
                break;
            }
            default: {
                throw new ApiException(ErrorCode.OPERATION_ERROR, "不支持该请求");
            }
        }
        //发送请求
        return httpRequest.addHeaders(getHeaders(JSONUtil.toJsonStr(request), dongApiClient))
                .body(JSONUtil.toJsonStr(request.getRequestParams()));
    }



    /**
     * 拼接Get请求
     *
     * @param request 要求
     * @param path    结尾路径:/api/xx
     * @return {@link String}
     */
    private <O, T extends ResultResponse> String splicingGetRequest(BaseRequest<O, T> request, String path) {
        StringBuilder urlBuilder = new StringBuilder(getewayHost);
        // urlBuilder最后是/结尾且path以/开头的情况下，去掉urlBuilder结尾的/,也就是http://localhost:8090/api/XX。防止有人将路径加个前缀/。
        if (urlBuilder.toString().endsWith("/") && path.startsWith("/")) {
            urlBuilder.setLength(urlBuilder.length() - 1);
        }
        //拼接path后缀也就是具体请求的接口路径/XXX-->http://localhost:8090/api/XXX
        urlBuilder.append(path);
        //请求参数不为空http://localhost:8090/api/XXX?aa=aa&bb=bb&cc=cc
        if (!request.getRequestParams().isEmpty()) {
            urlBuilder.append("?");
            //将请求参数以键值对形式拼接
            for (Map.Entry<String, Object> entry : request.getRequestParams().entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue().toString();
                urlBuilder.append(key).append("=").append(value).append("&");
            }
            //因为拼接完后是http://localhost:8090/api/XXX? aaa = aaa & bbb = bbb &,多了个&必须删掉
            urlBuilder.deleteCharAt(urlBuilder.length() - 1);
        }
        log.info("GET请求路径：{}", urlBuilder);
        return urlBuilder.toString();
    }


    /**
     * 获取请求头
     *
     * @param body 请求体
     * @param dongApiClient qi api客户端
     * @return {@link Map}<{@link String}, {@link String}>
     */
    private Map<String, String> getHeaders(String body, DongApiClient dongApiClient) {
        Map<String, String> hashMap = new HashMap<>(4);
        hashMap.put("accessKey", dongApiClient.getAccessKey());
        String encodedBody = SecureUtil.md5(body);
        hashMap.put("body", encodedBody);
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.getSign(encodedBody, dongApiClient.getSecretKey()));
        return hashMap;
    }

    @Override
    public <O, T extends ResultResponse> T request(BaseRequest<O, T> request) throws ApiException {
        try {
            return res(request);
        } catch (Exception e) {
            throw new ApiException(ErrorCode.OPERATION_ERROR, e.getMessage());
        }
    }

    @Override
    public <O, T extends ResultResponse> T request(DongApiClient dongApiClient, BaseRequest<O, T> request) throws ApiException {
        checkConfig(dongApiClient);
        return request(request);
    }


}
