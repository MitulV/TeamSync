package com.project.TeamSync.Controller;


import com.project.TeamSync.Entity.Team;
import com.project.TeamSync.Service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/team")
@RequiredArgsConstructor
public class TeamController {

    private final TeamService teamService;

    @GetMapping("/{id}")
    public ResponseEntity<Team> get(@PathVariable Long id){
        return ResponseEntity.ok(teamService.get(id));
    }

    @GetMapping("/")
    public ResponseEntity<List<Team>> get(){
        return ResponseEntity.ok(teamService.get());
    }

    public ResponseEntity<Team> create(Team team){
        return ResponseEntity.ok(teamService.create(team));
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Boolean> update(@PathVariable Long id, @RequestBody Team team){
        return ResponseEntity.ok(teamService.update(id,team));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable Long id){
        return ResponseEntity.ok(teamService.delete(id));
    }
}
