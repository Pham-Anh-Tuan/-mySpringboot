package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fullname;
    private String email;
    private String password;
    @Column(name = "phone_number")
    private String phoneNumber;
    @JsonFormat(pattern = "dd-MM-yyyy ss:mm:HH")
    private Timestamp birthday;
    private String gender;

}
