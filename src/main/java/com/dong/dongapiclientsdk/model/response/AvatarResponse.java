package com.dong.dongapiclientsdk.model.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 小众头像返回类
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class AvatarResponse extends ResultResponse{
    private static final long serialVersionUID = 979136414684487042L;
    private String type;
    private String url;
}
