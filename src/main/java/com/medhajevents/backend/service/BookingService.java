package com.medhajevents.backend.service;

public interface BookingService {
    void bookEvent(Long eventId, String userEmail);
}
