package com.fortunate.customer.service.impl;

import com.fortunate.clients.fraud.FraudClient;
import com.fortunate.clients.notification.NotificationRequest;
import com.fortunate.clients.notification.NotificationClient;
import com.fortunate.customer.entity.Customer;
import com.fortunate.customer.payload.request.CustomerRegistrationRequest;
import com.fortunate.clients.fraud.FraudCheckResponse;
import com.fortunate.customer.repository.CustomerRepository;
import com.fortunate.customer.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final FraudClient fraudClient;
    private final NotificationClient notificationClient;

    public void registerCustomer(CustomerRegistrationRequest customerRegistrationRequest) {
        Customer customer = Customer.builder()
                .firstName(customerRegistrationRequest.firstName())
                .lastName(customerRegistrationRequest.lastName())
                .email(customerRegistrationRequest.email())
                .build();
        //Todo: check if email is valid
        //Todo: check if email already exists
        customerRepository.saveAndFlush(customer);
        //Todo: check if a fraudster is trying to register
        FraudCheckResponse fraudCheckResponse = fraudClient.isFraudster(customer.getId());

        if (fraudCheckResponse.fraudulent()) {
            throw new RuntimeException("Customer is a fraudster");
        }

        //notificationClient.sendNotification(
        NotificationRequest notificationRequest =
                new NotificationRequest(
                        customer.getId(),
                        customer.getEmail(),
                        String.format("Hi %s, welcome to Fortunate microservices...", customer.getFirstName())


        );
        notificationClient.sendNotification(notificationRequest);
    }
}
