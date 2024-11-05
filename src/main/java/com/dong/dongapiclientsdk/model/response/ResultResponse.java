package com.dong.dongapiclientsdk.model.response;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
public class ResultResponse implements Serializable {
    private static final long serialVersionUID = -6486005224268968744L;

    /**
     * 当你有一个 Java 对象，但你想在 JSON 序列化时包含一些动态生成的键值对（这些键值对可能不是对象字段的直接映射），
     * 你可以使用 @JsonAnyGetter。
     * 这个注解应该应用于一个方法上，该方法返回一个 Map，其中包含了所有要序列化为 JSON 的额外键值对。
     */
    private Map<String, Object> data = new HashMap<>();

    @JsonAnyGetter
    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }
}