package com.example.demo.service.impl;
;
import com.example.demo.model.Appointment;
import com.example.demo.model.Schedule;
import com.example.demo.repository.AppointmentRepository;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private ScheduleRepository scheduleRepository;

    @Override
    public Appointment addAppointment(Appointment appointment) {
        Schedule sc = appointment.getSchedule();
        sc.setBooked(1);
        scheduleRepository.save(sc);
        return appointmentRepository.save(appointment);
    }
}
