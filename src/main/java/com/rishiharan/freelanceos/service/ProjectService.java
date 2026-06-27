package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.ProjectRequestDTO;
import com.rishiharan.freelanceos.dto.ProjectResponseDTO;
import com.rishiharan.freelanceos.exception.ContactNotFoundException;
import com.rishiharan.freelanceos.exception.ProjectNotFoundException;
import com.rishiharan.freelanceos.model.Contact;
import com.rishiharan.freelanceos.model.Project;
import com.rishiharan.freelanceos.repository.ContactRepository;
import com.rishiharan.freelanceos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final ContactRepository contactRepository;

    public ProjectService(ProjectRepository projectRepository,
                          ContactRepository contactRepository) {
        this.projectRepository = projectRepository;
        this.contactRepository = contactRepository;
    }

    // CREATE PROJECT
    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {

        if (dto.getContactId() == null) {
            throw new IllegalArgumentException("contactId is required");
        }

        Contact contact = contactRepository.findById(dto.getContactId())
                .orElseThrow(() ->
                        new ContactNotFoundException("Contact not found with id: " + dto.getContactId()));

        Project project = new Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setContact(contact);

        Project saved = projectRepository.save(project);

        return mapToDTO(saved);
    }

    // GET ALL PROJECTS
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll()
                .stream()
                .map(this::mapToDTO)
                .toList();
    }

    // GET PROJECT BY ID
    public ProjectResponseDTO getProjectById(Long id) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found with id: " + id));

        return mapToDTO(project);
    }

    // UPDATE PROJECT
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO dto) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException("Project not found with id: " + id));

        if (dto.getContactId() == null) {
            throw new IllegalArgumentException("contactId is required");
        }

        Contact contact = contactRepository.findById(dto.getContactId())
                .orElseThrow(() ->
                        new ContactNotFoundException("Contact not found with id: " + dto.getContactId()));

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setContact(contact);

        Project updated = projectRepository.save(project);

        return mapToDTO(updated);
    }

    // DELETE PROJECT
    public void deleteProject(Long id) {

        if (!projectRepository.existsById(id)) {
            throw new ProjectNotFoundException("Project not found with id: " + id);
        }

        projectRepository.deleteById(id);
    }

    // MAPPER (SAFE)
    private ProjectResponseDTO mapToDTO(Project p) {

        Long contactId = null;
        String contactName = null;

        if (p.getContact() != null) {
            contactId = p.getContact().getId();
            contactName = p.getContact().getName();
        }

        return new ProjectResponseDTO(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getStatus(),
                contactId,
                contactName
        );
    }
}