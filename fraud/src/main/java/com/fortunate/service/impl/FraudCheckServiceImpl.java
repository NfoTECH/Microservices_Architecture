package com.fortunate.service.impl;

import com.fortunate.entity.FraudCheckHistory;
import com.fortunate.repository.FraudCheckHistoryRepository;
import com.fortunate.service.FraudCheckService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class FraudCheckServiceImpl implements FraudCheckService {

    private final FraudCheckHistoryRepository fraudCheckHistoryRepository;

    @Override
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(FraudCheckHistory.builder()
                .customerId(customerId)
                .isFraudster(false)
                .createdAt(LocalDateTime.now())
                .build());
        return false;
    }
}
