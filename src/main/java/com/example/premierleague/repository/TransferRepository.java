package com.example.premierleague.repository;

import com.example.premierleague.model.Team;
import com.example.premierleague.model.Transfer;
import com.example.premierleague.model.TransferRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
