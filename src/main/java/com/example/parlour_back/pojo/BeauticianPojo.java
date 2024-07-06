package com.example.parlour_back.pojo;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BeauticianPojo {

    private Long beauticianId;
    private String email;
    private String fullName;
    private String phone; // Changed to String for handling phone numbers
    private String password;

    // Constructors can be added if necessary, but lombok may handle them implicitly
}
