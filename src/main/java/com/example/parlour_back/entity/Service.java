package com.example.parlour_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name ="services")
@Getter
@Setter


public class Service {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "service_id_generator")
    @SequenceGenerator(name="service_id_generator",sequenceName = "service_seq",allocationSize=1)
    private Long service_id;

    @Column(name = "service name" ,length = 50)
    private String serviceName;

    @Column(name = "price" ,length = 10)
    private double price;



}