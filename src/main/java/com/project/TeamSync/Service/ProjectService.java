package com.project.TeamSync.Service;

import com.project.TeamSync.Entity.Project;
import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Repository.ProjectRepository;
import com.project.TeamSync.Repository.TeamRepository;
import com.project.TeamSync.Request.CreateProjectRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final TeamRepository teamRepository;

    public Project create(CreateProjectRequest request){
        Project project=Project.builder().name(request.getName()).description(request.getDescription()).build();
        if(request.getTeamId()!=null){
            Team team=teamRepository.findById(request.getTeamId()).orElse(null);
            if(team!=null){
                project.setTeam(team);
                return projectRepository.save(project);
            }
        }
       return null;
    }

    public Project get(Long id){
        return projectRepository.findById(id).orElse(null);
    }

    public List<Project> get(){
        return projectRepository.findAll();
    }

    public boolean update(Long id,Project project){
        Project existingProject=projectRepository.findById(id).orElse(null);
        if(existingProject!=null){
            if(project.getName()!=null){
                existingProject.setName(project.getName());
            }
            if(project.getDescription()!=null){
                existingProject.setDescription(project.getDescription());
            }
            projectRepository.save(existingProject);
            return true;
        }
        return false;
    }

    public boolean delete(Long id){
        Project project=projectRepository.findById(id).orElse(null);
        if(project!=null){
            projectRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
