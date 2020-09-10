package ch.zli.m223.punchclock.controller;


import ch.zli.m223.punchclock.domain.Entry;
import ch.zli.m223.punchclock.domain.Project;
import ch.zli.m223.punchclock.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Path;
import java.util.List;

@RestController
@RequestMapping("/project")
public class ProjectController {

private ProjectService projectService;

public ProjectController(ProjectService projectService){
    this.projectService = projectService;
}

    /**
     * Gibt eine Liste mit allen Projekten zurück
     * @return List<Project>
     */
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Project> getAllProjects(){
    return projectService.findAll();
    }

    /**
    * Erstellt einen neuen Projekt Datensatz
    * @param project
     **/
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Project createProject(@Valid @RequestBody Project project){
    return projectService.createProject(project);
    }

    /**
     * Löscht ein Projekt Datensatz über die Projekt ID
     * @param id
     */
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProject(@PathVariable("id") Long id){
    projectService.deleteProject(id);
    }

    /**
     * Aktualisiert einen Projekt Datensatz
     * @param project
     * @return
     */
    @PutMapping
    @ResponseStatus(HttpStatus.OK)
    public Project updateProject(@Valid @RequestBody Project project){
    return projectService.updateProject(project);
    }



}
