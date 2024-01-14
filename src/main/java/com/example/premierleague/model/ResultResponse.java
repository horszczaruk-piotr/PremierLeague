package com.example.premierleague.model;

import lombok.Builder;

@Builder
public record ResultResponse(Team homeTeam, Team awayTeam, int homeTeamScored, int awayTeamScored) {
}
