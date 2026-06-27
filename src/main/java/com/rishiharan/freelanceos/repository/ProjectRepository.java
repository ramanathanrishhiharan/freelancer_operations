package com.rishiharan.freelanceos.repository;

import com.rishiharan.freelanceos.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
