package com.temple.model.mapper;

import com.temple.model.dto.request.CreateReceiptDto;
import com.temple.model.dto.response.ReceiptDto;
import com.temple.model.entity.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ReceiptMapper {

    @Mapping(target = "oid", ignore = true)
    @Mapping(target = "date", ignore = true)
    Receipt toEntity(CreateReceiptDto createReceiptDto);

    ReceiptDto toDto(Receipt receipt);
}
