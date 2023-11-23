package com.example.premierleague.service;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.repository.FootballerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

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

  public Long fullUpdateFootballer(Long id, Footballer footballer){
      Optional<Footballer> existing = footballerRepository.findById(id);

      if (existing==null){
          createFootballer(footballer);
      } else {
          footballer.setId(existing.get().getId());
          footballerRepository.save(footballer);
      }
      return existing.get().getId();
  }

  public void partialUpdateFootballer(Long id, Map<String, Object> updates){
      var existing = this.footballerRepository.findById(id);

      if (existing.isPresent()) {
          var footballer =  existing.get();

          if (updates.containsKey("name")) {
              String newName = updates.get("name").toString();
              footballer.setName(newName);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("surname")) {
              String newSurname = updates.get("surname").toString();
              footballer.setSurname(newSurname);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("age")) {
              int newAge = Integer.parseInt(updates.get("age").toString());
              footballer.setAge(newAge);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("country")) {
              String newCountry = updates.get("country").toString();
              footballer.setCountry(newCountry);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("position")) {
              String newPosition = updates.get("position").toString();
              footballer.setPosition(newPosition);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("number")) {
              int newNumber = Integer.parseInt(updates.get("number").toString());
              footballer.setNumber(newNumber);
              footballerRepository.save(footballer);
          }
          if (updates.containsKey("team")) {
              String newTeam = updates.get("team").toString();
              footballer.setTeam(newTeam);
              footballerRepository.save(footballer);
          } else {
              throw new IllegalArgumentException("There is no such an ID.");
          }
      }
  }

}
