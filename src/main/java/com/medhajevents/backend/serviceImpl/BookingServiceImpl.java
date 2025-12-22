package com.medhajevents.backend.serviceImpl;

import com.medhajevents.backend.exception.ResourceNotFoundException;
import com.medhajevents.backend.model.Booking;
import com.medhajevents.backend.model.Event;
import com.medhajevents.backend.model.User;
import com.medhajevents.backend.repository.BookingRepository;
import com.medhajevents.backend.repository.EventRepository;
import com.medhajevents.backend.repository.UserRepository;
import com.medhajevents.backend.service.BookingService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserRepository userRepository;
    private final EventRepository eventRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              UserRepository userRepository,
                              EventRepository eventRepository) {
        this.bookingRepository = bookingRepository;
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
    }

    @Override
    public void bookEvent(Long eventId, String userEmail) {

        User user = userRepository.findByEmail(userEmail)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));

        Booking booking = Booking.builder()
                .user(user)
                .event(event)
                .status(Booking.Status.CONFIRMED)
                .bookingDate(LocalDateTime.now())
                .build();

        bookingRepository.save(booking);
    }
}
