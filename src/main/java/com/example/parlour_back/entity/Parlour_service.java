package com.example.parlour_back.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "parlour_services")
@Getter
@Setter
public class Parlour_service {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "parlour_service_seq_gen")
    @SequenceGenerator(name = "parlour_service_seq_gen", sequenceName = "parlour_service_seq", allocationSize = 1)
    @Column(name = "parlour_service_id")
    private Long parlourServiceId;

    @Column(name = "status", length = 10)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "beautician_id", referencedColumnName = "beautician_id", nullable = false, foreignKey = @ForeignKey(name = "fk_beautician_id"))
    private Beautician beautician;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "service_id", referencedColumnName = "service_id", nullable = false, foreignKey = @ForeignKey(name = "fk_service_id"))
    private Service service;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "appointment_id", referencedColumnName = "appointment_id", nullable = false, foreignKey = @ForeignKey(name = "fk_appointment_id"))
    private Appointment appointment;

    // Constructors, getters, and setters can be added if necessary
}
