package com.project.TeamSync.Service;

import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeamService {

    @Autowired
    private final TeamRepository teamRepository;

    public Team create(Team team){
        return teamRepository.save(team);
    }

    public Team get(Long id){
        return teamRepository.findById(id).orElse(null);
    }

    public List<Team> get(){
        return teamRepository.findAll();
    }

    public boolean update(Long id,Team team){
        Team existingTeam=teamRepository.findById(id).orElse(null);
        if(existingTeam!=null){
            if(team.getName()!=null){
                existingTeam.setName(team.getName());
            }
            if(team.getDescription()!=null){
                existingTeam.setDescription(team.getDescription());
            }
            teamRepository.save(existingTeam);
            return true;
        }
        return false;
    }

    public boolean delete(Long id){
        Team team=teamRepository.findById(id).orElse(null);
        if(team!=null){
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }

}
