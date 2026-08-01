package com.clatpredictor.api.dto;

public record ClosingRankResponse(
    String collegeName,
    String city,
    int year,
    int closingRank,
    String roundLabel,
    String sourceUrl
) {}
