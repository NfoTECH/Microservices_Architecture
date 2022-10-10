package com.fortunate.customer.payload.request;

import lombok.Getter;

public record CustomerRegistrationRequest (String firstName, String lastName, String email) {
}
