package com.medhajevents.backend.controller;

import com.medhajevents.backend.dto.ApiResponse;
import com.medhajevents.backend.dto.TestimonialDto;
import com.medhajevents.backend.model.Testimonial;
import com.medhajevents.backend.repository.TestimonialRepository;
import com.medhajevents.backend.service.TestimonialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/testimonials")
public class TestimonialController {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Autowired
    private TestimonialService testimonialService;

    public TestimonialController(TestimonialRepository testimonialRepository) {
        this.testimonialRepository = testimonialRepository;
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ApiResponse<TestimonialDto> createTestimonials(@RequestBody TestimonialDto request){

        return ApiResponse.success(
                "Testimonial Created Successfully",
                testimonialService.createTestimonial(request)

        );

    }
    @GetMapping
    public ApiResponse<List<Testimonial>> getAll() {
        return ApiResponse.success(
                "Testimonials fetched",
                testimonialRepository.findAll()
        );
    }
}
