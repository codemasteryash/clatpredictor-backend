package com.clatpredictor.api.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Entity
@Table(
    name = "closing_ranks",
    uniqueConstraints = @UniqueConstraint(columnNames = {"college_id", "program_id", "year", "category", "quota_type", "home_state", "round_label"})
)
public class ClosingRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "college_id", nullable = false)
    private College college;

    @ManyToOne(optional = false)
    @JoinColumn(name = "program_id", nullable = false)
    private Program program;

    @NotNull
    private Integer year;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Category category;

    @NotNull
    @Enumerated(EnumType.STRING)
    private QuotaType quotaType = QuotaType.ALL_INDIA;


    private String homeState;

    @NotNull
    private Integer closingRank;

    @NotBlank
    private String roundLabel = "final";

    @NotBlank
    @Column(length = 500)
    private String sourceUrl;

    public ClosingRank() {}

    public Long getId() { return id; }
    public College getCollege() { return college; }
    public void setCollege(College college) { this.college = college; }
    public Program getProgram() { return program; }
    public void setProgram(Program program) { this.program = program; }
    public Integer getYear() { return year; }
    public void setYear(Integer year) { this.year = year; }
    public Category getCategory() { return category; }
    public void setCategory(Category category) { this.category = category; }
    public QuotaType getQuotaType() { return quotaType; }
    public void setQuotaType(QuotaType quotaType) { this.quotaType = quotaType; }
    public String getHomeState() { return homeState; }
    public void setHomeState(String homeState) { this.homeState = homeState; }
    public Integer getClosingRank() { return closingRank; }
    public void setClosingRank(Integer closingRank) { this.closingRank = closingRank; }
    public String getRoundLabel() { return roundLabel; }
    public void setRoundLabel(String roundLabel) { this.roundLabel = roundLabel; }
    public String getSourceUrl() { return sourceUrl; }
    public void setSourceUrl(String sourceUrl) { this.sourceUrl = sourceUrl; }
}
