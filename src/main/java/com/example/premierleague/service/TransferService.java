package com.example.premierleague.service;

import com.example.premierleague.model.Team;
import com.example.premierleague.model.Transfer;
import com.example.premierleague.model.TransferRequest;
import com.example.premierleague.repository.TransferRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class TransferService {
    private final TransferRepository transferRepository;

    public Transfer createTransfer(TransferRequest transferRequest) {
        Transfer transfer = new Transfer();
        transfer.setTransferDate(LocalDateTime.now());
        transfer.setTransferValue(transferRequest.transferValue());
        transfer.setFootballerId(transferRequest.footballerId());
        transfer.setNewTeamId(transferRequest.newTeamId());
        transfer.setOldTeamId(transferRequest.oldTeamId());

        return transferRepository.save(transfer);
    }

    public void deleteTransfer(Transfer transfer){
        transferRepository.delete(transfer);
    }
}
