package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;


@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public Project createProject(Project project) {
        return projectRepository.saveAndFlush(project);
    }

    public void deleteProject(Long id) {
        projectRepository.deleteById(id);
    }

    public Project updateProject(Project project) {
        if (projectRepository.findById(project.getId()).isPresent()) {
            return projectRepository.save(project);
        }
        return null;
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }


}
