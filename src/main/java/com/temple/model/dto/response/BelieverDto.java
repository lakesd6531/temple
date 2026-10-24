package com.temple.model.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class BelieverDto {

    @JsonProperty("id")
    private Integer oid;
    private String name;
    private String phone;
    private String cellPhone;
    private String address;
    private String birthday;
    private String idNumber;
}
