package com.temple.service;

import com.temple.model.dto.request.CreateReceiptDto;
import com.temple.model.dto.response.ReceiptDto;
import com.temple.model.entity.Receipt;
import com.temple.model.mapper.ReceiptMapper;
import com.temple.repository.ReceiptRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReceiptService {

    private final ReceiptMapper receiptMapper;
    private final ReceiptRepository receiptRepository;

    @Transactional
    public Integer createReceipt(CreateReceiptDto createReceiptDto) {
        Receipt receipt = receiptMapper.toEntity(createReceiptDto);
        receipt.setDate(LocalDate.now());

        return receiptRepository.save(receipt).getOid();
    }

    public List<ReceiptDto> findAllReceipt() {
        List<Receipt> receiptList = receiptRepository.findAllByOrderByDateDescOidDesc();

        return receiptList.stream()
                .map(receiptMapper::toDto)
                .toList();
    }
}
