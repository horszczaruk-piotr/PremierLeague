package com.example.premierleague.controller;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.model.Team;
import com.example.premierleague.service.FootballerService;
import com.example.premierleague.service.TeamService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("teams")
public class TeamController {
    private final TeamService teamService;

    @GetMapping
    public List<Team> getListOfTeams() {

        var teamList = teamService.getTeams();
        return teamList;
    }
    @GetMapping("{id}")
    public ResponseEntity<Team> getTeam(@PathVariable Long id){
        var team = teamService.getTeamById(id);
        if (team.isPresent()) {
            return new ResponseEntity<>(team.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<List<Team>> addTeam(@RequestBody List<Team> newTeamList){
        return new ResponseEntity<>(teamService.createTeams(newTeamList), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteTeam(@PathVariable Long id){
        try {
            teamService.deleteTeam(id);
            log.info("The team with id: "+ id +" has been deleted.");
            return ResponseEntity.status(HttpStatus.OK).body("The team with id: "+ id +" has been deleted.") ;
        }catch (Exception exception){
            log.error(exception.getMessage()+" - Error deleting team with id "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting team with id "+id);
        }
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> updateTeam(@PathVariable Long id, @RequestBody Team team) {
        Long updatedTeamId = this.teamService.fullUpdateTeam(id, team);

        if (updatedTeamId==id){
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.created(URI.create("id/"+updatedTeamId)).build();
        }
    }

    @PatchMapping("{id}")
    public void patchTeam(@RequestBody Map<String, Object> updates, @PathVariable Long id) {
        this.teamService.partialUpdateTeam(id,updates);
    }
}
