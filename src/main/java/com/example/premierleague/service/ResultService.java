package com.example.premierleague.service;

import com.example.premierleague.model.Result;

import com.example.premierleague.model.Team;
import com.example.premierleague.repository.ResultRepository;
import com.example.premierleague.repository.TeamRepository;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final TeamRepository teamRepository;

    public Result createResult(Result result) {
    return resultRepository.save(result);
    }

    public void deleteResult (Long id){
        resultRepository.deleteById(id);
    }

    @Transactional
    public List<Result> generateResults() {
        List<Team> teamList = teamRepository.findAll();
        resultRepository.deleteAll();
        List<Result> results = generateResults(teamList);
        resultRepository.saveAll(results);
        return results;
    }

    private List<Result> generateResults(List<Team> teamList) {
        List<Result> results = new ArrayList<>();
        for (Team teamHome: teamList) {
            for (Team teamAway: teamList) {
                if (teamHome.equals(teamAway)) continue;
                results.add(generateRandomResult(teamHome,teamAway));
                results.add(generateRandomResult(teamAway, teamHome));
            }
        }
        return results;
    }

    private Result generateRandomResult(Team teamHome, Team teamAway){
        Random random = new Random();
        return new Result(teamHome, teamAway, random.nextInt(10), random.nextInt(10));
    }
}

