package com.clatpredictor.api.controller;

import com.clatpredictor.api.dto.PredictionLogRequest;
import com.clatpredictor.api.model.Category;
import com.clatpredictor.api.model.PredictionLog;
import com.clatpredictor.api.repository.PredictionLogRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PredictionLogController {

    private final PredictionLogRepository repo;

    public PredictionLogController(PredictionLogRepository repo) {
        this.repo = repo;
    }


    @PostMapping("/predictions-log")
    @ResponseStatus(HttpStatus.CREATED)
    public void log(@Valid @RequestBody PredictionLogRequest req) {
        PredictionLog entry = new PredictionLog();
        entry.setRank(req.rank());
        entry.setCategory(Category.valueOf(req.category()));
        entry.setProgramId(req.programId());
        entry.setHomeStateApplied(req.homeStateApplied());
        entry.setResultsCount(req.resultsCount());
        repo.save(entry);
    }


    @GetMapping("/stats")
    public Map<String, Object> stats() {
        List<PredictionLog> all = repo.findAll();
        Map<Category, Long> byCategory = all.stream()
            .collect(java.util.stream.Collectors.groupingBy(PredictionLog::getCategory, java.util.stream.Collectors.counting()));
        return Map.of("totalPredictions", all.size(), "byCategory", byCategory);
    }
}
