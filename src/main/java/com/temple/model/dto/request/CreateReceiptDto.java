package com.temple.model.dto.request;

import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateReceiptDto {

    @NotNull
    @JsonAlias({"believerId", "believerOid"})
    private Integer believerOid;

    @NotNull
    private String believerName;

    @NotNull
    private Integer total;

    @NotNull
    private String category;

    @NotNull
    private String handler;
}
