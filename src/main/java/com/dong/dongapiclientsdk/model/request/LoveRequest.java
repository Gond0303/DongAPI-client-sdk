package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.LoveParams;
import com.dong.dongapiclientsdk.model.response.LoveResponse;
import lombok.experimental.Accessors;

/**
 * 随机情话请求
 */
@Accessors(chain = true)
public class LoveRequest extends BaseRequest<LoveParams, LoveResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/loveTalk";
    }

    @Override
    public Class<LoveResponse> getResponseClass() {
        return LoveResponse.class;
    }
}
