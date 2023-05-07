package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@Data
@Entity
@Table(name = "schedule")
public class Schedule {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm:ss")
    @Column(name = "time_meet")
    private Timestamp timeToMeet;

    private int booked;

    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private DetalService detalService;

    @ManyToOne
    @JoinColumn(name = "doctor_id", nullable = false)
    private Doctor doctor;

    public String dayMY() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-LL-yyyy");
        LocalDateTime localDateTime = this.timeToMeet.toLocalDateTime();
        LocalDate localDate = localDateTime.toLocalDate();
        return localDate.format(dateFormatter);
    }

    // Trả ra giờ và phút của start_time
    public String hourMinute() {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("HH:mm");
        LocalDateTime localDateTime = this.timeToMeet.toLocalDateTime();
        LocalTime localTime = localDateTime.toLocalTime();
        return localTime.format(dateFormatter);
    }

}
