package com.temple.service;

import com.temple.model.dto.request.CreateLightDto;
import com.temple.model.dto.request.CreateLightReceiptDto;
import com.temple.model.dto.response.LightDto;
import com.temple.model.dto.response.LightItemDto;
import com.temple.model.entity.Light;
import com.temple.model.entity.LightItem;
import com.temple.model.entity.LightItemDetail;
import com.temple.model.mapper.LightItemMapper;
import com.temple.model.mapper.LightMapper;
import com.temple.repository.LightItemDetailRepository;
import com.temple.repository.LightItemRepository;
import com.temple.repository.LightRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LightService {

    private final LightRepository lightRepository;
    private final LightItemRepository lightItemRepository;
    private final LightItemDetailRepository lightItemDetailRepository;
    private final LightMapper lightMapper;
    private final LightItemMapper lightItemMapper;

    @Transactional
    public Integer createLight(CreateLightDto createLightDto) {
        Light light = lightMapper.toEntity(createLightDto);
        return lightRepository.save(light).getOid();
    }

    public List<LightDto> findAllLight() {
        return lightRepository.findAllByOrderByYearDescOidDesc().stream()
                .map(lightMapper::toDto)
                .toList();
    }

    @Transactional
    public Integer createLightReceipt(CreateLightReceiptDto dto) {
        LightItem lightItem = lightItemMapper.toEntity(dto);
        lightItem.setDate(LocalDate.now());
        LightItem savedItem = lightItemRepository.save(lightItem);

        if (dto.getNames() != null && !dto.getNames().isEmpty()) {
            List<LightItemDetail> details = dto.getNames().stream()
                    .map(String::trim)
                    .filter(name -> !name.isEmpty())
                    .map(name -> {
                        LightItemDetail detail = new LightItemDetail();
                        detail.setLightItemOid(savedItem.getOid());
                        detail.setName(name);
                        return detail;
                    })
                    .toList();
            lightItemDetailRepository.saveAll(details);
        }

        return savedItem.getOid();
    }

    public List<LightItemDto> findItemsByLightOid(Integer lightOid) {
        List<LightItem> items = lightItemRepository.findByLightOidOrderByDateDescOidDesc(lightOid);
        if (items.isEmpty()) {
            return Collections.emptyList();
        }

        List<Integer> itemOids = items.stream().map(LightItem::getOid).toList();
        List<LightItemDetail> allDetails = lightItemDetailRepository.findByLightItemOidInOrderByOidAsc(itemOids);

        Map<Integer, List<String>> detailsMap = allDetails.stream()
                .collect(Collectors.groupingBy(
                        LightItemDetail::getLightItemOid,
                        Collectors.mapping(LightItemDetail::getName, Collectors.toList())
                ));

        return items.stream().map(item -> {
            LightItemDto dto = lightItemMapper.toDto(item);
            dto.setNames(detailsMap.getOrDefault(item.getOid(), Collections.emptyList()));
            return dto;
        }).toList();
    }
}
