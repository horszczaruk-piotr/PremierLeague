package com.example.premierleague.model;

import lombok.Builder;

@Builder
public record FootballerResponse(String name, String surname, int age, String country, String position, int number) {
}
