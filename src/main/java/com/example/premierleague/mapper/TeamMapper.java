package com.example.premierleague.mapper;

import com.example.premierleague.model.Result;
import com.example.premierleague.model.Team;
import com.example.premierleague.model.TeamResponse;
import org.mapstruct.Mapper;

@Mapper
public interface TeamMapper {
    TeamResponse toTeamResponse(Team team);
}
