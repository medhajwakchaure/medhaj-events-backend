package com.medhajevents.backend.serviceImpl;

import com.medhajevents.backend.dto.EventResponse;
import com.medhajevents.backend.dto.TestimonialDto;
import com.medhajevents.backend.model.Event;
import com.medhajevents.backend.model.Testimonial;
import com.medhajevents.backend.repository.TestimonialRepository;
import com.medhajevents.backend.service.TestimonialService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TestimonialServiceImpl implements TestimonialService {

    @Autowired
    private TestimonialRepository testimonialRepository;

    @Override
    public TestimonialDto createTestimonial(TestimonialDto request){
        Testimonial testimonial=new Testimonial();
        testimonial.setClientName(request.getClientName());
        testimonial.setMessage(request.getMessage());
        testimonial.setRating(request.getRating());
        testimonial.setCreatedAt(LocalDateTime.now());

        testimonialRepository.save(testimonial);
        BeanUtils.copyProperties(testimonial,request);

        return request;


    }


}
