package com.example.premierleague.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Entity
@Data
public class Footballer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String surname;
    int age;
    String country;
    String position;
    int number;
    String team;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Footballer that = (Footballer) o;
        return age == that.age && number == that.number && Objects.equals(name, that.name) && Objects.equals(surname, that.surname) && Objects.equals(country, that.country) && Objects.equals(position, that.position) && Objects.equals(team, that.team);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, country, position, number, team);
    }
}
