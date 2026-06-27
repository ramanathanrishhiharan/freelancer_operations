package com.rishiharan.freelanceos.repository;

import com.rishiharan.freelanceos.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}