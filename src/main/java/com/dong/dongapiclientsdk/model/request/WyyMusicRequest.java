package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.WyyMusicParams;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * 网易云请求
 */
//链式调用set返回的是自身这个对象
@Accessors(chain = true)
public class WyyMusicRequest extends BaseRequest<WyyMusicParams, ResultResponse> {
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/wyMusic";
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
