package com.fortunate.customer.service;

import com.fortunate.customer.payload.request.CustomerRegistrationRequest;

public interface CustomerService  {

    void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest);
}
