package com.medhajevents.backend.serviceImpl;

import com.medhajevents.backend.dto.EventResponse;
import com.medhajevents.backend.exception.ResourceNotFoundException;
import com.medhajevents.backend.model.Event;
import com.medhajevents.backend.repository.EventRepository;
import com.medhajevents.backend.service.EventService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<EventResponse> getAllEvents() {
        return eventRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public EventResponse createEvent(EventResponse request) {
        Event event = Event.builder()
                .name(request.getName())
                .description(request.getDescription())
                .date(request.getDate())
                .location(request.getLocation())
                .price(request.getPrice())
                .imageUrl(request.getImageUrl())
                .category(request.getCategory())
                .build();

        return mapToResponse(eventRepository.save(event));
    }

    @Override
    public void deleteEvent(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Event not found"));
        eventRepository.delete(event);
    }

    private EventResponse mapToResponse(Event event) {
        return EventResponse.builder()
                .id(event.getId())
                .name(event.getName())
                .description(event.getDescription())
                .date(event.getDate())
                .location(event.getLocation())
                .price(event.getPrice())
                .imageUrl(event.getImageUrl())
                .category(event.getCategory())
                .build();
    }
}
