package com.project.TeamSync.Controller;

import com.project.TeamSync.Entity.Project;
import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Request.CreateProjectRequest;
import com.project.TeamSync.Service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ProjectController {

    private ProjectService projectService;

    @GetMapping("/{id}")
    public ResponseEntity<Project> get(@PathVariable Long id){
        return ResponseEntity.ok(projectService.get(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Project>> get(){
        return ResponseEntity.ok(projectService.get());
    }

    public ResponseEntity<Project> create(CreateProjectRequest request){
        return ResponseEntity.ok(projectService.create(request));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody Project project){
        return ResponseEntity.ok(projectService.update(id,project));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(projectService.delete(id));
    }
}
