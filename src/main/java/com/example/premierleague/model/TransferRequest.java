package com.example.premierleague.model;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Date;

public record TransferRequest(Long footballerId, Long oldTeamId, Long newTeamId, BigInteger transferValue) {
}
