package com.temple.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LightDto {

    @JsonProperty("id")
    private Integer oid;

    private String year;
}
