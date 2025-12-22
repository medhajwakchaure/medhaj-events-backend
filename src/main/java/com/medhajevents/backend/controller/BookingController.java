package com.medhajevents.backend.controller;

import com.medhajevents.backend.dto.ApiResponse;
import com.medhajevents.backend.service.BookingService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/{eventId}")
    @PreAuthorize("hasRole('USER')")
    public ApiResponse<Void> bookEvent(@PathVariable Long eventId,
                                       Authentication authentication) {

        bookingService.bookEvent(eventId, authentication.getName());
        return ApiResponse.success("Event booked successfully");
    }
}
