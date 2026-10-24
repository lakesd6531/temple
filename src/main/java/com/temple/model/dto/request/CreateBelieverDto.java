package com.temple.model.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateBelieverDto {

    @NotNull
    private String name;

    @NotNull
    private String phone;

    @NotNull
    private String cellPhone;

    @NotNull
    private String address;

    private String birthday;

    private String idNumber;
}
