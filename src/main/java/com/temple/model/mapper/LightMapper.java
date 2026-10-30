package com.temple.model.mapper;

import com.temple.model.dto.request.CreateLightDto;
import com.temple.model.dto.response.LightDto;
import com.temple.model.entity.Light;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface LightMapper {

    @Mapping(target = "oid", ignore = true)
    Light toEntity(CreateLightDto createLightDto);

    LightDto toDto(Light light);
}
