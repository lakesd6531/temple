package com.temple.repository;

import com.temple.model.entity.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReceiptRepository extends JpaRepository<Receipt, Integer> {

    List<Receipt> findAllByOrderByDateDescOidDesc();
}
