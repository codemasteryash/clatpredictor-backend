package com.clatpredictor.api.repository;

import com.clatpredictor.api.model.Category;
import com.clatpredictor.api.model.ClosingRank;
import com.clatpredictor.api.model.QuotaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClosingRankRepository extends JpaRepository<ClosingRank, Long> {


    List<ClosingRank> findByProgram_NameAndCategoryAndQuotaTypeAndRoundLabelOrderByCollege_Name(
        String programName, Category category, QuotaType quotaType, String roundLabel
    );


    List<ClosingRank> findByCollege_NameAndProgram_NameAndCategoryAndQuotaTypeOrderByYear(
        String collegeName, String programName, Category category, QuotaType quotaType
    );
}
