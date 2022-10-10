package com.fortunate.payload.request;

public record NotificationRequest(Integer toCustomerId, String toCustomerEmail, String message) {
}