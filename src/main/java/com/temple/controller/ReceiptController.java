package com.temple.controller;

import com.temple.model.dto.request.CreateReceiptDto;
import com.temple.model.dto.response.ReceiptDto;
import com.temple.service.ReceiptService;
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
public class ReceiptController {

    private final ReceiptService receiptService;

    @PostMapping("/receipt")
    public ResponseEntity<Integer> create(@RequestBody @Valid CreateReceiptDto createReceiptDto) {
        return ResponseEntity.status(HttpStatus.OK).body(receiptService.createReceipt(createReceiptDto));
    }

    @GetMapping("/receipt")
    public ResponseEntity<List<ReceiptDto>> find() {
        return ResponseEntity.status(HttpStatus.OK).body(receiptService.findAllReceipt());
    }
}
