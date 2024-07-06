package com.example.parlour_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "beautician")
@Getter
@Setter
public class Beautician {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "beautician_id_generator")
    @SequenceGenerator(name = "beautician_id_generator", sequenceName = "beautician_seq", allocationSize = 1)
    @Column(name = "beautician_id")
    private Long beauticianId;

    @Column(name = "full_name", length = 50)
    private String fullName;

    @Column(name = "email", length = 50)
    private String email;

    @Column(name = "password", length = 20)
    private String password;

    @Column(name = "phone_no", length = 15)
    private String phoneNumber; // Changed to String for handling phone numbers

    // Constructors, getters, and setters can be added if necessary
}
