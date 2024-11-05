package com.dong.dongapiclientsdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class WyyMusicParams implements Serializable {
    private static final long serialVersionUID = -3303844677243919045L;

    private String type;
}
