package com.temple.service;

import com.temple.model.dto.request.CreateBelieverDto;
import com.temple.model.dto.request.UpdateBelieverDto;
import com.temple.model.dto.response.BelieverDto;
import com.temple.model.entity.Believer;
import com.temple.model.mapper.BelieverMapper;
import com.temple.repository.BelieverRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<BelieverDto> findAllBeliever(){
        List<Believer> believerList = believerRepository.findAll();

        return believerList.stream()
                .map(believerMapper::toDto)
                .toList();
    }

    @Transactional
    public Integer updateBeliever(UpdateBelieverDto updateBelieverDto) {
        Integer id = updateBelieverDto.getId();

        Believer believer = believerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("找不到信徒 ID: " + id));

        believerMapper.updateEntityFromDto(updateBelieverDto, believer);

        return believerRepository.save(believer).getOid();
    }

    @Transactional
    public Integer deleteBeliever(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("信徒 ID 不能為空");
        }

        Believer believer = believerRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("找不到信徒 ID: " + id));

        believerRepository.delete(believer);

        return id;
    }
}
