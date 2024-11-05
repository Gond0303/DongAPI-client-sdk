package com.dong.dongapiclientsdk.model.response.responsePackage;


import lombok.Data;

import java.io.Serializable;

/**
 * 网易云接口封装类
 */
@Data
public class Info implements Serializable {
    private static final long serialVersionUID = -3725059279867211882L;
    private String name;

    private String auther;

    private String pic_url;

    private String url;

}
