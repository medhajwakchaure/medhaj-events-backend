package com.medhajevents.backend.dto;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponse {

    private Long bookingId;
    private String eventName;
    private String userEmail;
    private String status;
    private LocalDateTime bookingDate;
}
