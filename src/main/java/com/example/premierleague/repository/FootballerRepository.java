package com.example.premierleague.repository;

import com.example.premierleague.model.Footballer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FootballerRepository extends JpaRepository<Footballer, Long> {

}
