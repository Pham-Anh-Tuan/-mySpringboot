package com.example.demo.model;

import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "appointment")
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    @NotBlank
    private String username;
    @NotBlank
    @Column(nullable = false)
    private String phone;
    @NotBlank
    @Column(nullable = false)
    private String email;
//    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @OneToOne
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;
}
