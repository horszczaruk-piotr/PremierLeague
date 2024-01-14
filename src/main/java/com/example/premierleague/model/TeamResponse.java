package com.example.premierleague.model;

import lombok.Builder;

@Builder
public record TeamResponse(String teamName, String country, String city, int yearFounded) {
}
