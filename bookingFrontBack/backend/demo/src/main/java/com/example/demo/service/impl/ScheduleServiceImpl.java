package com.example.demo.service.impl;

import com.example.demo.model.Schedule;
import com.example.demo.repository.ScheduleRepository;
import com.example.demo.service.ScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ScheduleServiceImpl implements ScheduleService {
    @Autowired
    private ScheduleRepository appointmentRepository;

    @Override
    public List<String> findDateByServiceIdDoctorId(Long serviceId, Long doctorId) {
        Set<String> dates = appointmentRepository.findByServiceIdDoctorId(serviceId, doctorId)
                .stream().map(Schedule::dayMY).collect(Collectors.toSet());
        return new ArrayList<>(dates);
    }

    @Override
    public List<String> findTimeHMByServiceIdDoctorIdDate(Long serviceId, Long doctorId, String date) {
        Set<String> timeHMList = appointmentRepository.findByServiceIdDoctorIdDate(serviceId, doctorId, strToDate(date)).stream().map(Schedule::hourMinute).collect(Collectors.toSet());
        return new ArrayList<>(timeHMList);
    }

    @Override
    public Schedule findByServiceIdDoctorIdDateTimeHM(Long serviceId, Long doctorId, String date, String timeHM) {
        List<Schedule> list = appointmentRepository.findByServiceIdDoctorIdDate(serviceId, doctorId, strToDate(date))
                .stream().filter(appointment -> appointment.hourMinute().equals(timeHM))
                .collect(Collectors.toList());
        return list.get(0);
    }

    public Date strToDate(String date) {
        String[] split = date.split("-");
        String dateYMD = split[2] + "-" + split[1] + "-" + split[0];
        return Date.valueOf(dateYMD);
    }


}
