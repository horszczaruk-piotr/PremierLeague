package com.example.premierleague.service;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FootballerService {
    private final FootballerRepository footballerRepository;

  public List<Footballer> getFootballers() {
        return footballerRepository.findAll();
  }

  public Optional<Footballer> getFootballerById(long id) {
      return footballerRepository.findById(id);
  }

  public Footballer createFootballer(Footballer footballer) {
      return footballerRepository.save(footballer);
  }

  public List<Footballer> createFootballers(List<Footballer> footballerList) {
        return footballerRepository.saveAll(footballerList);
  }

  public void deleteFootballer(long id) {
        footballerRepository.deleteById(id);

  }
  public void editFootballer(Footballer footballer) {
      return;
  }

  public List<Footballer> deleteFootballerDuplicates() {
      var footballerList = footballerRepository.findAll();
      List<Footballer> footballerDuplicates = new ArrayList<>();
      var uniqueSetFootballer = new HashSet<>();
      footballerList.forEach(
              footballer -> {
                  if (!uniqueSetFootballer.add(footballer)) {
                      footballerDuplicates.add(footballer);
                  }
              }
      );
      footballerRepository.deleteAll(footballerDuplicates);
      return footballerDuplicates;
  }
}
