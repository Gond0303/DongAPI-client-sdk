package com.dong.dongapiclientsdk.model.request;


import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.AvatarParams;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import lombok.experimental.Accessors;

/**
 * 小众头像请求类
 */
@Accessors(chain = true)
public class AvatarRequest extends BaseRequest<AvatarParams, ResultResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/avatar";
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
