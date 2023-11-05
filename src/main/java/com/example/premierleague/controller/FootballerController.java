package com.example.premierleague.controller;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.service.FootballerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("footballers")
public class FootballerController {
    private final FootballerService footballerService;

    @GetMapping
    public List<Footballer> getListOfFootballers() {

        var footballerList = footballerService.getFootballers();
        return footballerList;
    }
    @GetMapping("{id}")
    public ResponseEntity<Footballer> getFootballer(@PathVariable Long id){
        var footballer = footballerService.getFootballerById(id);
        if (footballer.isPresent()) {
            return new ResponseEntity<>(footballer.get(), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PostMapping
    public ResponseEntity<List<Footballer>> addFootballer(@RequestBody List<Footballer> newFootballerList){
        return new ResponseEntity<>(footballerService.createFootballers(newFootballerList), HttpStatus.CREATED);
    }

    @DeleteMapping("{id}")
    public ResponseEntity deleteFootballer(@PathVariable Long id){
        try {
            footballerService.deleteFootballer(id);
            log.info("The footballer with id: "+ id +" has been deleted.");
            return ResponseEntity.status(HttpStatus.OK).body("The footballer with id: "+ id +" has been deleted.") ;
        }catch (Exception exception){
            log.error(exception.getMessage()+" - Error deleting footballer with id "+id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting footballer with id "+id);
        }

    }
}
