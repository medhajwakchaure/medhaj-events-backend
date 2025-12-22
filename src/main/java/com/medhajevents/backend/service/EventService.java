package com.medhajevents.backend.service;

import com.medhajevents.backend.dto.EventResponse;
import java.util.List;

public interface EventService {
    List<EventResponse> getAllEvents();
    EventResponse createEvent(EventResponse request);
    void deleteEvent(Long id);
}
