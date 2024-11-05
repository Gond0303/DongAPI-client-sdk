package com.dong.dongapiclientsdk.model.request;

import com.dong.dongapiclientsdk.model.enums.RequestMethodEnum;
import com.dong.dongapiclientsdk.model.params.WeatherParams;
import com.dong.dongapiclientsdk.model.response.ResultResponse;
import lombok.experimental.Accessors;


/**
 * 天气请求
 */
@Accessors(chain = true)
public class WeatherRequest extends BaseRequest<WeatherParams, ResultResponse>{
    @Override
    public String getMethod() {
        return RequestMethodEnum.GET.getValue();
    }

    @Override
    public String getPath() {
        return "/weather";
    }

    @Override
    public Class<ResultResponse> getResponseClass() {
        return ResultResponse.class;
    }
}
