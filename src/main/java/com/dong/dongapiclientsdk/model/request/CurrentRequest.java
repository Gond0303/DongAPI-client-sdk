package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * 当前的请求
 * @Accessors(chain = true)自动生成链式调用的setter方法
 */
@Accessors(chain = true)
public class CurrentRequest extends BaseRequest<Object, ResultResponse> {
    //方法
    private String method;
    //路径
    private String path;

    /**
     * 获取方法
     */
    @Override
    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * 获取路径
     */
    @Override
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link ResultResponse}>
     */
    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}