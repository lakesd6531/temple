package com.temple.model.mapper;

import com.temple.model.dto.request.CreateLightReceiptDto;
import com.temple.model.dto.response.LightItemDto;
import com.temple.model.entity.LightItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LightItemMapper {

    @Mapping(target = "oid", ignore = true)
    @Mapping(target = "date", ignore = true)
    LightItem toEntity(CreateLightReceiptDto createLightReceiptDto);

    @Mapping(target = "names", ignore = true)
    LightItemDto toDto(LightItem lightItem);
}
