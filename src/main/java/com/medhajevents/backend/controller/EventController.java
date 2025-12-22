package com.medhajevents.backend.controller;

import com.medhajevents.backend.dto.ApiResponse;
import com.medhajevents.backend.dto.EventResponse;
import com.medhajevents.backend.service.EventService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('USER','ADMIN')")
    public ApiResponse<List<EventResponse>> getAllEvents() {
        return ApiResponse.success(
                "Events fetched successfully",
                eventService.getAllEvents()
        );
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<EventResponse> createEvent(
            @RequestBody EventResponse request) {

        return ApiResponse.success(
                "Event created successfully",
                eventService.createEvent(request)
        );
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<Void> deleteEvent(@PathVariable Long id) {

        eventService.deleteEvent(id);
        return ApiResponse.success("Event deleted successfully");
    }
}
