package com.dong.dongapiclientsdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 获取名字参数类
 */
@Data
@Accessors(chain = true)
public class NameParams implements Serializable {

    private static final long serialVersionUID = -7768756397934476736L;
    private String name;
}