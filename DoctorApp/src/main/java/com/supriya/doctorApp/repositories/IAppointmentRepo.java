package com.supriya.doctorApp.repositories;

import com.supriya.doctorApp.models.Appointment;
import com.supriya.doctorApp.models.AppointmentKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAppointmentRepo extends JpaRepository<Appointment, AppointmentKey> {

}
