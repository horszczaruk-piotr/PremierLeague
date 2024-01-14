package com.example.premierleague.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "homeTeam_id")
    Team homeTeam;

    @ManyToOne
    @JoinColumn(name = "awayTeam_id")
    Team awayTeam;

    int homeTeamScored;
    int awayTeamScored;

    public Result(Team homeTeam, Team awayTeam, int homeTeamScored, int awayTeamScored) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeTeamScored = homeTeamScored;
        this.awayTeamScored = awayTeamScored;
    }
}
