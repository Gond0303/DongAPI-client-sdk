package com.dong.dongapiclientsdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class DyParams implements Serializable {
    private static final long serialVersionUID = 8867569695556944500L;
    private String type;
}
