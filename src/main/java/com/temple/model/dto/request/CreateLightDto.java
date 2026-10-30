package com.temple.model.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateLightDto {

    @NotBlank(message = "年份不可為空")
    private String year;
}
