package com.temple.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class CreateLightReceiptDto {

    @NotNull(message = "點燈年份ID不可為空")
    @JsonAlias({"lightId", "lightOid"})
    private Integer lightOid;

    @NotBlank(message = "地址不可為空")
    private String address;

    @NotBlank(message = "種類不可為空")
    private String category;

    @NotBlank(message = "電話不可為空")
    private String phone;

    @NotBlank(message = "經手人不可為空")
    private String handler;

    @NotNull(message = "金額不可為空")
    private Integer total;

    @NotEmpty(message = "姓名清單不可為空")
    private List<String> names;
}
