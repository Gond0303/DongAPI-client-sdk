package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.BddjParams;
import com.dong.dongapiclientsdk.model.response.ResultResponse;

public class BddjRequest extends BaseRequest<BddjParams, ResultResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/bddj";
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
