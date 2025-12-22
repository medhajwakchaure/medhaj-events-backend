package com.medhajevents.backend.controller;

import com.medhajevents.backend.dto.ApiResponse;
import com.medhajevents.backend.model.Contact;
import com.medhajevents.backend.repository.ContactRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/contact")
public class ContactController {

    private final ContactRepository contactRepository;

    public ContactController(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @PostMapping
    public ApiResponse<Void> saveMessage(@RequestBody Contact contact) {
        contact.setCreatedAt(LocalDateTime.now());
        contactRepository.save(contact);
        return ApiResponse.success("Message submitted successfully");
    }
}
