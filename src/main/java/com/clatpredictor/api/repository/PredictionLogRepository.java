package com.clatpredictor.api.repository;

import com.clatpredictor.api.model.PredictionLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PredictionLogRepository extends JpaRepository<PredictionLog, Long> {
}
