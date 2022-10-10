package com.fortunate.customer.controller;

import com.fortunate.customer.service.CustomerService;
import com.fortunate.customer.payload.request.CustomerRegistrationRequest;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @PostMapping("/register")
    public void registerCustomer(@RequestBody CustomerRegistrationRequest customerRegistrationRequest) {
        log.info("new customer registration: {}", customerRegistrationRequest);
        customerService.registerCustomer(customerRegistrationRequest);
    }
}
