package com.clatpredictor.api.controller;

import com.clatpredictor.api.dto.ClosingRankResponse;
import com.clatpredictor.api.dto.HistoryPoint;
import com.clatpredictor.api.model.Category;
import com.clatpredictor.api.model.ClosingRank;
import com.clatpredictor.api.model.QuotaType;
import com.clatpredictor.api.repository.ClosingRankRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ClosingRankController {

    private final ClosingRankRepository closingRankRepository;

    public ClosingRankController(ClosingRankRepository closingRankRepository) {
        this.closingRankRepository = closingRankRepository;
    }

    @GetMapping("/closing-ranks")
    public List<ClosingRankResponse> getClosingRanks(
        @RequestParam(defaultValue = "GENERAL") Category category,
        @RequestParam(defaultValue = "BA LLB (Hons.)") String program,
        @RequestParam(defaultValue = "ALL_INDIA") QuotaType quota,
        @RequestParam(defaultValue = "final") String round
    ) {
        return closingRankRepository
            .findByProgram_NameAndCategoryAndQuotaTypeAndRoundLabelOrderByCollege_Name(program, category, quota, round)
            .stream()
            .map(cr -> new ClosingRankResponse(
                cr.getCollege().getName(),
                cr.getCollege().getCity(),
                cr.getYear(),
                cr.getClosingRank(),
                cr.getRoundLabel(),
                cr.getSourceUrl()
            ))
            .toList();
    }


    @GetMapping("/colleges/{name}/history")
    public List<HistoryPoint> getHistory(
        @PathVariable String name,
        @RequestParam(defaultValue = "GENERAL") Category category,
        @RequestParam(defaultValue = "BA LLB (Hons.)") String program
    ) {
        return closingRankRepository
            .findByCollege_NameAndProgram_NameAndCategoryAndQuotaTypeOrderByYear(name, program, category, QuotaType.ALL_INDIA)
            .stream()
            .map(cr -> new HistoryPoint(cr.getYear(), cr.getClosingRank(), cr.getSourceUrl()))
            .toList();
    }
}
