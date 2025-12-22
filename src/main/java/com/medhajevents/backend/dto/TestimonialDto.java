package com.medhajevents.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestimonialDto {

    private String clientName;
    private String message;
    private Integer rating;
}
