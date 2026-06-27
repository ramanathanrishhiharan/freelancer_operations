package com.rishiharan.freelanceos.controller;

import com.rishiharan.freelanceos.dto.ProjectRequestDTO;
import com.rishiharan.freelanceos.dto.ProjectResponseDTO;
import com.rishiharan.freelanceos.service.ProjectService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    private final ProjectService projectService;
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }
    @PostMapping
    public ProjectResponseDTO create(@RequestBody ProjectRequestDTO dto) {
        return projectService.createProject(dto);

    }
    @GetMapping
    public List<ProjectResponseDTO> getAll() {
        return projectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ProjectResponseDTO getById(@PathVariable Long id) {
        return projectService.getProjectById(id);
    }
    @PutMapping("/{id}")
    public ProjectResponseDTO updateProject(
            @PathVariable Long id,
            @RequestBody ProjectRequestDTO dto) {

        return projectService.updateProject(id, dto);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        projectService.deleteProject(id);
        return "Project deleted successfully";
    }
}
