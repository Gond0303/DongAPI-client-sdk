package com.dong.dongapiclientsdk.client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 调用第三方接口的客户端
 *
 * @author 黄伟东
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DongApiClient {

//    private static final String GATEWAY_HOST = "http://localhost:8090";

    /**
     * 访问密钥
     */
    private String accessKey;
    /**
     * 密钥
     */
    private String secretKey;

  /*

    public String getNameByGet(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        String result = HttpUtil.get(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public String getNameByPost(String name) {
        //可以单独传入http参数，这样参数会自动做URL编码，拼接在URL中
        HashMap<String, Object> paramMap = new HashMap<>();
        paramMap.put("name",name);
        String result = HttpUtil.post(GATEWAY_HOST+"/api/name/", paramMap);
        System.out.println(result);
        return result;
    }

    public Map<String,String> getHeaders(String body){
        Map<String,String> hashMap = new HashMap<>();
        //请求头中放入五个参数。1.签名标识 2.用户信息 3.签名 4.随机数 5.时间戳
        //解决body中的中文乱码
        String encode = "";
        try {
            encode = URLEncoder.encode(body,"utf-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        hashMap.put("accessKey",accessKey);
        hashMap.put("body",encode);
        hashMap.put("sign", SignUtils.getSign(body,secretKey));
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        hashMap.put("timestamp",String.valueOf(System.currentTimeMillis()/1000));
        return hashMap;
    }

    //restful的post请求
    public String getUsernameByPost(User user) {
        String json = JSONUtil.toJsonStr(user);
        HttpResponse httpResponse = HttpRequest.post(GATEWAY_HOST+"/api/name/user")
                .addHeaders(getHeaders(json))
                .body(json)
                .execute();
        String body =  httpResponse.body();
        System.out.println(body);
//        System.out.println(httpResponse);
        return body;
    }*/
}
