package com.clatpredictor.api.dto;

import jakarta.validation.constraints.NotNull;

public record PredictionLogRequest(
    @NotNull Integer rank,
    @NotNull String category,
    Long programId,
    boolean homeStateApplied,
    int resultsCount
) {}
