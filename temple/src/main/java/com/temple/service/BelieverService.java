package com.temple.service;

import com.temple.model.dto.request.CreateBelieverDto;
import com.temple.model.entity.Believer;
import com.temple.model.mapper.BelieverMapper;
import com.temple.repository.BelieverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class BelieverService {

    private final BelieverMapper believerMapper;
    private final BelieverRepository believerRepository;

    @Transactional
    public Integer createBeliever(CreateBelieverDto createBelieverDto) {
        Believer believer = believerMapper.toEntity(createBelieverDto);

        return believerRepository.save(believer).getOid();
    }
}
