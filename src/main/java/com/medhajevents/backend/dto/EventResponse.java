package com.medhajevents.backend.dto;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EventResponse {

    private Long id;
    private String name;
    private String description;
    private LocalDate date;
    private String location;
    private BigDecimal price;
    private String imageUrl;
    private String category;
}
