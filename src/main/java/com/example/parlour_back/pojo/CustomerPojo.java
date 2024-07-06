package com.example.parlour_back.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerPojo {

    private Long customerId;
    private String password; // Changed to String for password handling
    private String fullName;
    private String phoneNumber; // Changed to String for handling phone numbers
    private String email;

    // Constructors can be added if necessary, but lombok may handle them implicitly
}
