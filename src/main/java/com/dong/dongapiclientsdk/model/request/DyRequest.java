package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.DyParams;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

@Accessors(chain = true)
public class DyRequest extends BaseRequest<DyParams, ResultResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/xjj";
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
