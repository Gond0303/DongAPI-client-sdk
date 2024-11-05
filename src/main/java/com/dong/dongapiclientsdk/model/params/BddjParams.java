package com.dong.dongapiclientsdk.model.params;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class BddjParams  implements Serializable {
    private static final long serialVersionUID = 8471907622827439297L;

    private String text;
    private String list;
    private String today;
}
