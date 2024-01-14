package com.example.premierleague.mapper;

import com.example.premierleague.model.Footballer;
import com.example.premierleague.model.FootballerResponse;
import com.example.premierleague.model.Result;
import com.example.premierleague.model.ResultResponse;
import org.mapstruct.Mapper;

@Mapper
public interface FootballerMapper {
    FootballerResponse toFootballerResponse(Footballer footballer);
}
