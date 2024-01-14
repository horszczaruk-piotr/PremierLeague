package com.example.premierleague.mapper;

import com.example.premierleague.model.Result;
import com.example.premierleague.model.ResultResponse;
import org.mapstruct.Mapper;

@Mapper
public interface ResultMapper {
    ResultResponse toResultResponse(Result result);
}
