package com.example.premierleague.repository;

import com.example.premierleague.model.Result;
import com.example.premierleague.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResultRepository extends JpaRepository<Result, Long> {
}
