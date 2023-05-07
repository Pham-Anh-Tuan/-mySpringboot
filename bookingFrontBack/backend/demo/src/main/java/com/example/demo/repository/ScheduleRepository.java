package com.example.demo.repository;

import com.example.demo.model.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
    @Query("SELECT a FROM Schedule a WHERE a.detalService.id =?1 AND a.doctor.id =?2 AND a.booked=0")
    public List<Schedule> findByServiceIdDoctorId(Long serviceId, Long doctorId);

    @Query("SELECT a FROM Schedule a WHERE a.detalService.id =?1 AND a.doctor.id =?2 AND function('DATE', a.timeToMeet) =?3 AND a.booked=0")
    public List<Schedule> findByServiceIdDoctorIdDate(Long serviceId, Long doctorId, Date date);

}
