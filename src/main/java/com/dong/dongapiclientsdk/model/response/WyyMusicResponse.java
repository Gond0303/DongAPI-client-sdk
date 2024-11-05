package com.dong.dongapiclientsdk.model.response;


import com.dong.dongapiclientsdk.model.response.responsePackage.Info;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 网易云音乐返回类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WyyMusicResponse extends ResultResponse{
    private static final long serialVersionUID = -4118638119111838624L;
    /**
     * 响应封装体
     */
    private Info info;
}
