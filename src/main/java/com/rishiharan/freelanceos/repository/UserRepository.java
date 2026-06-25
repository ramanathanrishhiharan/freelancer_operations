package com.rishiharan.freelanceos.repository;

import com.rishiharan.freelanceos.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
