package com.rishiharan.freelanceos.service;

import com.rishiharan.freelanceos.dto.ProjectRequestDTO;
import com.rishiharan.freelanceos.dto.ProjectResponseDTO;
import com.rishiharan.freelanceos.exception.ClientNotFoundException;
import com.rishiharan.freelanceos.exception.ProjectNotFoundException;
import com.rishiharan.freelanceos.model.Client;
import com.rishiharan.freelanceos.model.Project;
import com.rishiharan.freelanceos.repository.ClientRepository;
import com.rishiharan.freelanceos.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final ClientRepository clientRepository;

    public ProjectService(ProjectRepository projectRepository, ClientRepository clientRepository) {
        this.projectRepository = projectRepository;
        this.clientRepository = clientRepository;
    }

    public ProjectResponseDTO createProject(ProjectRequestDTO dto) {
        Client client = clientRepository.findById(dto.getClientId()).orElseThrow(()-> new ClientNotFoundException("Client not found"));

        Project project = new  Project();
        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setClient(client);

        Project saved = projectRepository.save(project);
        return mapToDTO(saved);
    }
    public List<ProjectResponseDTO> getAllProjects() {
        return projectRepository.findAll().stream().map(this::mapToDTO).toList();
    }
    public ProjectResponseDTO getProjectById(Long id) {
        Project project = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found"));
        return mapToDTO(project);
    }
    public ProjectResponseDTO updateProject(Long id, ProjectRequestDTO dto) {

        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        Client client = clientRepository.findById(dto.getClientId())
                .orElseThrow(() -> new ClientNotFoundException("Client not found"));

        project.setName(dto.getName());
        project.setDescription(dto.getDescription());
        project.setStatus(dto.getStatus());
        project.setClient(client);

        Project updated = projectRepository.save(project);

        return mapToDTO(updated);
    }
    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }
    private ProjectResponseDTO mapToDTO(Project p) {
        return new ProjectResponseDTO(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getStatus(),
                p.getClient().getId(),
                p.getClient().getName()
        );
    }
}
