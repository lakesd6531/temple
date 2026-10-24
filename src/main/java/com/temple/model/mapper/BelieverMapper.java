package com.temple.model.mapper;

import com.temple.model.dto.request.CreateBelieverDto;
import com.temple.model.dto.response.BelieverDto;
import com.temple.model.entity.Believer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BelieverMapper {

    Believer toEntity(CreateBelieverDto believer);
    BelieverDto toDto(Believer believer);
}
