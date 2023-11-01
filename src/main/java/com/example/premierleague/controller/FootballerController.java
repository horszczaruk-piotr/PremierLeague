package com.example.premierleague.controller;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.service.FootballerService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
}
