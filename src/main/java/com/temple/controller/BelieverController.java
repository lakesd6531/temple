package com.temple.controller;

import com.temple.model.dto.request.CreateBelieverDto;
import com.temple.model.dto.response.BelieverDto;
import com.temple.service.BelieverService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/temple")
public class BelieverController {

    private final BelieverService believerService;

    @PostMapping("/believer")
    public ResponseEntity<Integer> create(@RequestBody @Valid CreateBelieverDto createBelieverDto) {
        return ResponseEntity.status(HttpStatus.OK).body(believerService.createBeliever(createBelieverDto));
    }

    @GetMapping("/believer")
    public ResponseEntity<List<BelieverDto>> find() {
        return ResponseEntity.status(HttpStatus.OK).body(believerService.findAllBeliever());
    }
}
