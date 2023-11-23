package com.example.premierleague.repository;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
