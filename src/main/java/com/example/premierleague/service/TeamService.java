package com.example.premierleague.service;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.model.Team;
import com.example.premierleague.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;

    public List<Team> getTeams() {
        return teamRepository.findAll();
    }

    public Optional<Team> getTeamById(long id) {
        return teamRepository.findById(id);
    }

    public Team createTeam(Team team) {
        return teamRepository.save(team);
    }

    public List<Team> createTeams(List<Team> teamList) {
        return teamRepository.saveAll(teamList);
    }

    public void deleteTeam(long id) {
        teamRepository.deleteById(id);
    }

    public Long fullUpdateTeam(Long id, Team team){
        Optional<Team> existing = teamRepository.findById(id);

        if (existing==null){
            createTeam(team);
        } else {
            team.setId(existing.get().getId());
            teamRepository.save(team);
        }
        return existing.get().getId();
    }

    public void partialUpdateTeam(Long id, Map<String, Object> updates){
        var existing = this.teamRepository.findById(id);

        if (existing.isPresent()) {
            var team =  existing.get();

            if (updates.containsKey("teamName")) {
                String newTeamName = updates.get("teamName").toString();
                team.setTeamName(newTeamName);
                teamRepository.save(team);
            }
            if (updates.containsKey("country")) {
                String newCountry = updates.get("country").toString();
                team.setCountry(newCountry);
                teamRepository.save(team);
            }
            if (updates.containsKey("city")) {
                String newCity = updates.get("city").toString();
                team.setCity(newCity);
                teamRepository.save(team);
            }
            if (updates.containsKey("yearFounded")) {
                int newYearFounded = Integer.parseInt(updates.get("").toString());
                team.setYearFounded(newYearFounded);
                teamRepository.save(team);
            } else {
                throw new IllegalArgumentException("There is no such an ID.");
            }
        }
    }
}
