package ch.zli.m223.punchclock.service;

import ch.zli.m223.punchclock.repository.ProjectRepository;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {
    private ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository){
        this.projectRepository=projectRepository;
    }


}
