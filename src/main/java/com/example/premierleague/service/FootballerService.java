package com.example.premierleague.service;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FootballerService {
    private final FootballerRepository footballerRepository;

  public List<Footballer> getFootballers(){
        return footballerRepository.findAll();
    }

    public List<Footballer> getRobertLewandowski() {
        List<Footballer> footballerList = new ArrayList<>();
        Footballer footballer = new Footballer("Robert", "Lewandowski", 34, "Poland", "Forward", 9, "FC Barcelona");
        footballerList.add(footballer);
        return footballerList;
    }
}
