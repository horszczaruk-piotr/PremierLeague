package com.example.premierleague.controller;

import com.example.premierleague.mapper.ResultMapper;
import com.example.premierleague.model.Result;


import com.example.premierleague.model.ResultResponse;
import com.example.premierleague.service.ResultService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("results")
public class ResultController {
    private final ResultService resultService;
    private final ResultMapper resultMapper;

    @PostMapping
    public ResponseEntity<Result> addResult(@RequestBody Result result) {
        return new ResponseEntity<>(resultService.createResult(result), HttpStatus.CREATED);
    }

    @DeleteMapping({"id"})
    public ResponseEntity deleteResult(@PathVariable Long id) {
        try {
            resultService.deleteResult(id);
            log.info("The result with id: " + id + " has been deleted.");
            return ResponseEntity.status(HttpStatus.OK).body("The result with id: " + id + " has been deleted.");
        } catch (Exception exception) {
            log.error(exception.getMessage() + " - Error deleting result with id " + id);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting result with id " + id);
        }
    }

    @PostMapping("generate")
    public ResponseEntity <List<ResultResponse>> generateResult(){
        val results = resultService.generateResults();
        val resultsResponse = results.stream().map(result -> resultMapper.toResultResponse(result)).toList();

        return new ResponseEntity<>(resultsResponse, HttpStatus.CREATED);
    }


}