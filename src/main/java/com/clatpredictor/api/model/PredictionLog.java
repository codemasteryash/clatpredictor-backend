package com.clatpredictor.api.model;

import jakarta.persistence.*;
import java.time.Instant;


@Entity
@Table(name = "predictions_log")
public class PredictionLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clat_rank")
    private Integer rank;

    @Enumerated(EnumType.STRING)
    private Category category;

    private Long programId;

    private boolean homeStateApplied;

    private int resultsCount;

    private Instant createdAt = Instant.now();

    public PredictionLog() {}

    public Long getId() { return id; }
    public Integer getRank() { return rank; }
    public void setRank(Integer rank) { this.rank = rank; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public Long getProgramId() { return programId; }
    public void setProgramId(Long programId) { this.programId = programId; }
    public boolean isHomeStateApplied() { return homeStateApplied; }
    public void setHomeStateApplied(boolean homeStateApplied) { this.homeStateApplied = homeStateApplied; }
    public int getResultsCount() { return resultsCount; }
    public void setResultsCount(int resultsCount) { this.resultsCount = resultsCount; }
    public Instant getCreatedAt() { return createdAt; }
}
