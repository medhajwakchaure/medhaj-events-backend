package com.medhajevents.backend.repository;

import com.medhajevents.backend.model.Booking;
import com.medhajevents.backend.model.Event;
import com.medhajevents.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByUser(User user);

    List<Booking> findByEvent(Event event);
}
