package com.dong.dongapiclientsdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class AvatarParams implements Serializable {
    private static final long serialVersionUID = -108236069283633361L;

    private String type;
}
