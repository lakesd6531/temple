package com.temple.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateReceiptDto {

    @JsonAlias({"believerId", "believerOid"})
    private Integer believerOid;

    @NotBlank(message = "信徒姓名不可為空")
    private String believerName;

    @NotNull
    private Integer total;

    @NotBlank
    private String category;

    @NotBlank
    private String handler;
}
