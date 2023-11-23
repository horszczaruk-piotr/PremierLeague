package com.example.premierleague.controller;

import com.example.premierleague.model.Team;
import com.example.premierleague.model.Transfer;
import com.example.premierleague.model.TransferRequest;
import com.example.premierleague.service.TransferService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("transfers")
public class TransferController {
    private final TransferService transferService;

    @PostMapping
    public ResponseEntity<Transfer> addTransfer(@RequestBody TransferRequest transferRequest){
        return new ResponseEntity<>(transferService.createTransfer(transferRequest), HttpStatus.CREATED);
    }
}
