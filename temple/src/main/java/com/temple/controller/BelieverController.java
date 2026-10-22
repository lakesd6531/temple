package com.temple.controller;

import com.temple.model.dto.request.CreateBelieverDto;
import com.temple.service.BelieverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/temple")
public class BelieverController {

    private final BelieverService believerService;

    @PostMapping("/believer")
    public ResponseEntity<Integer> create(@RequestBody @Valid CreateBelieverDto createBelieverDto) {
        return ResponseEntity.status(HttpStatus.OK).body(believerService.createBeliever(createBelieverDto));
    }
}
