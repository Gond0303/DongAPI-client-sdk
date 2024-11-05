package com.dong.dongapiclientsdk.model.request;

import cn.hutool.json.JSONUtil;
import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseRequest<O, T extends ResultResponse> {
    private Map<String, Object> requestParams = new HashMap<>();

    /**
     * 获取方法
     *
     * @return {@link RequestMethodEnum}
     */
    public abstract String getMethod();

    /**
     * 获取路径
     *
     * @return {@link String}
     */
    public abstract String getPath();

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link T}>
     */
    public abstract Class<T> getResponseClass();

    @JsonAnyGetter
    public Map<String, Object> getRequestParams() {
        return requestParams;
    }

    /**
     * 解析请求参数对象，将一个对象params转换成JSON字符串，然后再将这个JSON字符串解析成一个Map<String, Object>类型的对象
     * @param params
     */
    public void setRequestParams(O params) {
        this.requestParams = new Gson().fromJson(JSONUtil.toJsonStr(params), new TypeToken<Map<String, Object>>() {
        }.getType());
    }
}