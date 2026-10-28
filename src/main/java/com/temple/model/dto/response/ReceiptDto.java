package com.temple.model.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceiptDto {

    @JsonProperty("id")
    private Integer oid;

    private Integer believerOid;

    private String believerName;

    private Integer total;

    private String category;

    private String handler;

    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate date;
}
