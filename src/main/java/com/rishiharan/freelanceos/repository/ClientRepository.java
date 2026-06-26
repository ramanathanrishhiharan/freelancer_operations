package com.rishiharan.freelanceos.repository;

import com.rishiharan.freelanceos.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
