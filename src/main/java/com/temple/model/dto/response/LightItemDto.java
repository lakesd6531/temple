package com.temple.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
public class LightItemDto {

    @JsonProperty("id")
    private Integer oid;

    private Integer lightOid;

    private String address;

    private String category;

    private String phone;

    private String handler;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;

    private Integer total;

    private List<String> names;
}
