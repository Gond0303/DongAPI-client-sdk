package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.NameParams;
import com.dong.dongapiclientsdk.model.response.NameResponse;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class NameRequest extends BaseRequest<NameParams, NameResponse> {

    /**
     * 获取请求路径
     * @return
     */
    @Override
    public String getPath() {
        return "/name";
    }

    /**
     * 获取请求类型
     * @return
     */
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    /**
     * 获取响应类
     *
     * @return {@link Class}<{@link NameResponse}>
     */
    @Override
    public Class<NameResponse> getResponseClass() {
        return NameResponse.class;
    }



}