package com.dong.dongapiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 一周天气返回类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WeatherResponse extends ResultResponse{
    private static final long serialVersionUID = 329835948317885137L;
}
