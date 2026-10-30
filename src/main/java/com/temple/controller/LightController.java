package com.temple.controller;

import com.temple.model.dto.request.CreateLightDto;
import com.temple.model.dto.request.CreateLightReceiptDto;
import com.temple.model.dto.response.LightDto;
import com.temple.model.dto.response.LightItemDto;
import com.temple.service.LightService;
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
public class LightController {

    private final LightService lightService;

    @PostMapping("/light")
    public ResponseEntity<Integer> createLight(@RequestBody @Valid CreateLightDto createLightDto) {
        return ResponseEntity.status(HttpStatus.OK).body(lightService.createLight(createLightDto));
    }

    @GetMapping("/light")
    public ResponseEntity<List<LightDto>> findAllLight() {
        return ResponseEntity.status(HttpStatus.OK).body(lightService.findAllLight());
    }

    @PostMapping("/light/receipt")
    public ResponseEntity<Integer> createReceipt(@RequestBody @Valid CreateLightReceiptDto createLightReceiptDto) {
        return ResponseEntity.status(HttpStatus.OK).body(lightService.createLightReceipt(createLightReceiptDto));
    }

    @GetMapping("/light/{lightOid}/receipt")
    public ResponseEntity<List<LightItemDto>> findReceiptsByLight(@PathVariable("lightOid") Integer lightOid) {
        return ResponseEntity.status(HttpStatus.OK).body(lightService.findItemsByLightOid(lightOid));
    }
}
