package com.fortunate.controller;

import com.fortunate.clients.fraud.FraudCheckResponse;
import com.fortunate.service.FraudCheckService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/fraud-check")
public class FraudCheckController {

    private final FraudCheckService fraudCheckService;

    @GetMapping(path = "{customerId}")
    public FraudCheckResponse check(@PathVariable ("customerId") Integer customerID) {
        boolean isFraudulentCustomer = fraudCheckService.isFraudulentCustomer(customerID);
        log.info("Customer with id {} is a fraudster: {}", customerID, isFraudulentCustomer);
        return new FraudCheckResponse(isFraudulentCustomer);
    }
}
