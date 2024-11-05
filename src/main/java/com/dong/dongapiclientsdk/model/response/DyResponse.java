package com.dong.dongapiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 抖音视频返回类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class DyResponse extends ResultResponse{
    private static final long serialVersionUID = 1996702253771705743L;
    private String mp4_video;
}
