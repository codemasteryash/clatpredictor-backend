package com.clatpredictor.api.config;

import com.clatpredictor.api.model.*;
import com.clatpredictor.api.repository.ClosingRankRepository;
import com.clatpredictor.api.repository.CollegeRepository;
import com.clatpredictor.api.repository.ProgramRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class DataSeeder implements CommandLineRunner {

    private final CollegeRepository colleges;
    private final ProgramRepository programs;
    private final ClosingRankRepository closingRanks;

    private static final String SRC_LAWPREP_NLSIU = "https://www.lawpreptutorial.com/blog/national-law-universities/nlsiu-bangalore/cut-off/";
    private static final String SRC_LAWPREP_NUJS = "https://www.lawpreptutorial.com/blog/national-law-universities/nujs-kolkata/cut-off/";
    private static final String SRC_COLLEGEDEKHO_ROUND1 = "https://www.collegedekho.com/articles/clat-cut-off-opening-closing-ranks-round-1-general-obc-sc-st/";
    private static final String SRC_CAREERS360_TIERLIST = "https://law.careers360.com/articles/top-nlus-ranked-by-clat-cutoffs-not-nirf";
    private static final String SRC_ORIGINAL_2025 = "https://consortiumofnlus.ac.in";
    private static final String SRC_LAWPREP_NLIU = "https://www.lawpreptutorial.com/blog/national-law-universities/nliu-bhopal/cut-off/";
    private static final String SRC_COLLEGEDUNIA_JODHPUR = "https://s3.collegedunia.com/university/25834-national-law-university-nlu-jodhpur/cutoff";

    public DataSeeder(CollegeRepository colleges, ProgramRepository programs, ClosingRankRepository closingRanks) {
        this.colleges = colleges;
        this.programs = programs;
        this.closingRanks = closingRanks;
    }

    @Override
    public void run(String... args) {
        if (closingRanks.count() > 0) return;

        Program baLlb = programs.save(new Program("BA LLB (Hons.)"));
        Program bscLlb = programs.save(new Program("BSc LLB (Hons.)"));
        Program bbaLlb = programs.save(new Program("BBA LLB (Hons.)"));

        College nlsiu = colleges.save(new College("NLSIU Bengaluru", "Bengaluru"));
        save(nlsiu, baLlb, 2023, Category.GENERAL, 152, SRC_LAWPREP_NLSIU);
        save(nlsiu, baLlb, 2024, Category.GENERAL, 102, SRC_LAWPREP_NLSIU);
        save(nlsiu, baLlb, 2025, Category.GENERAL, 112, SRC_ORIGINAL_2025);
        save(nlsiu, baLlb, 2025, Category.EWS, 703, SRC_ORIGINAL_2025);
        save(nlsiu, baLlb, 2025, Category.OBC, 1541, SRC_ORIGINAL_2025);
        save(nlsiu, baLlb, 2025, Category.SC, 3133, SRC_ORIGINAL_2025);
        save(nlsiu, baLlb, 2025, Category.ST, 3396, SRC_ORIGINAL_2025);

        College nalsar = colleges.save(new College("NALSAR Hyderabad", "Hyderabad"));
        save(nalsar, baLlb, 2024, Category.GENERAL, 167, SRC_COLLEGEDEKHO_ROUND1);
        save(nalsar, baLlb, 2025, Category.GENERAL, 159, SRC_ORIGINAL_2025);
        save(nalsar, baLlb, 2025, Category.EWS, 546, SRC_ORIGINAL_2025);
        save(nalsar, baLlb, 2025, Category.OBC, 1219, SRC_ORIGINAL_2025);
        save(nalsar, baLlb, 2025, Category.SC, 3273, SRC_ORIGINAL_2025);
        save(nalsar, baLlb, 2025, Category.ST, 3621, SRC_ORIGINAL_2025);

        College wbnujs = colleges.save(new College("WBNUJS Kolkata", "Kolkata"));
        save(wbnujs, baLlb, 2023, Category.GENERAL, 260, SRC_LAWPREP_NUJS);
        save(wbnujs, baLlb, 2024, Category.GENERAL, 279, SRC_LAWPREP_NUJS);
        save(wbnujs, baLlb, 2025, Category.GENERAL, 327, SRC_ORIGINAL_2025);
        save(wbnujs, baLlb, 2025, Category.SC, 4753, SRC_ORIGINAL_2025);
        save(wbnujs, baLlb, 2025, Category.ST, 6343, SRC_ORIGINAL_2025);
        save(wbnujs, bscLlb, 2025, Category.GENERAL, 711, SRC_LAWPREP_NUJS);
        save(wbnujs, bscLlb, 2025, Category.OBC, 4596, SRC_LAWPREP_NUJS);

        College gnlu = colleges.save(new College("GNLU Gandhinagar", "Gandhinagar"));
        save(gnlu, baLlb, 2024, Category.GENERAL, 464, SRC_COLLEGEDEKHO_ROUND1);
        save(gnlu, baLlb, 2025, Category.GENERAL, 444, SRC_ORIGINAL_2025);
        save(gnlu, baLlb, 2025, Category.EWS, 1118, SRC_ORIGINAL_2025);
        save(gnlu, baLlb, 2025, Category.OBC, 2303, SRC_ORIGINAL_2025);
        save(gnlu, baLlb, 2025, Category.SC, 5934, SRC_ORIGINAL_2025);
        save(gnlu, baLlb, 2025, Category.ST, 8568, SRC_ORIGINAL_2025);

        College rmlnlu = colleges.save(new College("RMLNLU Lucknow", "Lucknow"));
        save(rmlnlu, baLlb, 2024, Category.GENERAL, 764, SRC_COLLEGEDEKHO_ROUND1);
        save(rmlnlu, baLlb, 2025, Category.GENERAL, 780, SRC_ORIGINAL_2025);

        College silvassa = colleges.save(new College("GNLU Silvassa Campus", "Silvassa"));
        save(silvassa, baLlb, 2023, Category.GENERAL, 1820, SRC_CAREERS360_TIERLIST);
        save(silvassa, baLlb, 2025, Category.GENERAL, 1461, SRC_ORIGINAL_2025);
        save(silvassa, baLlb, 2025, Category.EWS, 2620, SRC_ORIGINAL_2025);
        save(silvassa, baLlb, 2025, Category.SC, 8826, SRC_ORIGINAL_2025);
        save(silvassa, baLlb, 2025, Category.ST, 15112, SRC_ORIGINAL_2025);

        College nliuBhopal = colleges.save(new College("NLIU Bhopal", "Bhopal"));
        save(nliuBhopal, baLlb, 2025, Category.GENERAL, 480, SRC_ORIGINAL_2025);
        save(nliuBhopal, baLlb, 2025, Category.EWS, 1377, SRC_ORIGINAL_2025);
        save(nliuBhopal, baLlb, 2025, Category.OBC, 1757, SRC_ORIGINAL_2025);
        save(nliuBhopal, baLlb, 2025, Category.SC, 5763, SRC_ORIGINAL_2025);
        save(nliuBhopal, baLlb, 2025, Category.ST, 8243, SRC_ORIGINAL_2025);
        save(nliuBhopal, bscLlb, 2025, Category.GENERAL, 915, SRC_LAWPREP_NLIU);

        College nluJodhpur = colleges.save(new College("NLU Jodhpur", "Jodhpur"));
        save(nluJodhpur, baLlb, 2025, Category.GENERAL, 367, SRC_ORIGINAL_2025);
        save(nluJodhpur, baLlb, 2025, Category.EWS, 986, SRC_ORIGINAL_2025);
        save(nluJodhpur, baLlb, 2025, Category.OBC, 1776, SRC_ORIGINAL_2025);
        save(nluJodhpur, baLlb, 2025, Category.SC, 5445, SRC_ORIGINAL_2025);
        save(nluJodhpur, baLlb, 2025, Category.ST, 5955, SRC_ORIGINAL_2025);
        save(nluJodhpur, bbaLlb, 2022, Category.GENERAL, 356, SRC_COLLEGEDUNIA_JODHPUR);



        College hnlu = colleges.save(new College("HNLU Raipur", "Raipur"));
        save(hnlu, baLlb, 2025, Category.GENERAL, 807, SRC_ORIGINAL_2025);
        save(hnlu, baLlb, 2025, Category.OBC, 2408, SRC_ORIGINAL_2025);
        save(hnlu, baLlb, 2025, Category.SC, 7660, SRC_ORIGINAL_2025);
        save(hnlu, baLlb, 2025, Category.ST, 10507, SRC_ORIGINAL_2025);

        College rgnul = colleges.save(new College("RGNUL Patiala", "Patiala"));
        save(rgnul, baLlb, 2025, Category.GENERAL, 1279, SRC_ORIGINAL_2025);
        save(rgnul, baLlb, 2025, Category.OBC, 2067, SRC_ORIGINAL_2025);
        save(rgnul, baLlb, 2025, Category.SC, 8625, SRC_ORIGINAL_2025);
        save(rgnul, baLlb, 2025, Category.ST, 12742, SRC_ORIGINAL_2025);

        College cnlu = colleges.save(new College("CNLU Patna", "Patna"));
        save(cnlu, baLlb, 2025, Category.GENERAL, 1398, SRC_ORIGINAL_2025);

        College nusrl = colleges.save(new College("NUSRL Ranchi", "Ranchi"));
        save(nusrl, baLlb, 2025, Category.GENERAL, 1667, SRC_ORIGINAL_2025);
        save(nusrl, baLlb, 2025, Category.EWS, 2551, SRC_ORIGINAL_2025);
        save(nusrl, baLlb, 2025, Category.OBC, 3597, SRC_ORIGINAL_2025);
        save(nusrl, baLlb, 2025, Category.SC, 9902, SRC_ORIGINAL_2025);
        save(nusrl, baLlb, 2025, Category.ST, 15023, SRC_ORIGINAL_2025);

        College nluOdisha = colleges.save(new College("NLU Odisha", "Cuttack"));
        save(nluOdisha, baLlb, 2025, Category.GENERAL, 1013, SRC_ORIGINAL_2025);
        save(nluOdisha, baLlb, 2025, Category.SC, 7247, SRC_ORIGINAL_2025);
        save(nluOdisha, baLlb, 2025, Category.ST, 12967, SRC_ORIGINAL_2025);

        College nlujaa = colleges.save(new College("NLUJAA Assam", "Guwahati"));
        save(nlujaa, baLlb, 2025, Category.GENERAL, 2141, SRC_ORIGINAL_2025);

        College dsnlu = colleges.save(new College("DSNLU Visakhapatnam", "Visakhapatnam"));
        save(dsnlu, baLlb, 2025, Category.GENERAL, 1682, SRC_ORIGINAL_2025);
        save(dsnlu, baLlb, 2025, Category.EWS, 2571, SRC_ORIGINAL_2025);
        save(dsnlu, baLlb, 2025, Category.OBC, 3813, SRC_ORIGINAL_2025);
        save(dsnlu, baLlb, 2025, Category.SC, 9330, SRC_ORIGINAL_2025);
        save(dsnlu, baLlb, 2025, Category.ST, 15632, SRC_ORIGINAL_2025);

        College tnnlu = colleges.save(new College("TNNLU Tiruchirappalli", "Tiruchirappalli"));
        save(tnnlu, baLlb, 2025, Category.GENERAL, 1763, SRC_ORIGINAL_2025);
        save(tnnlu, baLlb, 2025, Category.OBC, 4082, SRC_ORIGINAL_2025);
        save(tnnlu, baLlb, 2025, Category.SC, 10327, SRC_ORIGINAL_2025);
        save(tnnlu, baLlb, 2025, Category.ST, 15384, SRC_ORIGINAL_2025);

        College mnluMumbai = colleges.save(new College("MNLU Mumbai", "Mumbai"));
        save(mnluMumbai, baLlb, 2025, Category.GENERAL, 1473, SRC_ORIGINAL_2025);

        College mnluNagpur = colleges.save(new College("MNLU Nagpur", "Nagpur"));
        save(mnluNagpur, baLlb, 2025, Category.GENERAL, 1529, SRC_ORIGINAL_2025);

        College mnluAurangabad = colleges.save(new College("MNLU Aurangabad", "Aurangabad"));
        save(mnluAurangabad, baLlb, 2025, Category.GENERAL, 1949, SRC_ORIGINAL_2025);

        College hpnlu = colleges.save(new College("HPNLU Shimla", "Shimla"));
        save(hpnlu, baLlb, 2025, Category.GENERAL, 2555, SRC_ORIGINAL_2025);
        save(hpnlu, baLlb, 2025, Category.SC, 11597, SRC_ORIGINAL_2025);
        save(hpnlu, baLlb, 2025, Category.ST, 18083, SRC_ORIGINAL_2025);

        College mpdnlu = colleges.save(new College("MPDNLU Jabalpur", "Jabalpur"));
        save(mpdnlu, baLlb, 2025, Category.GENERAL, 2243, SRC_ORIGINAL_2025);
        save(mpdnlu, baLlb, 2025, Category.EWS, 2922, SRC_ORIGINAL_2025);
        save(mpdnlu, baLlb, 2025, Category.OBC, 4228, SRC_ORIGINAL_2025);
        save(mpdnlu, baLlb, 2025, Category.SC, 11065, SRC_ORIGINAL_2025);
        save(mpdnlu, baLlb, 2025, Category.ST, 20674, SRC_ORIGINAL_2025);

        College dbranlu = colleges.save(new College("DBRANLU Sonepat", "Sonepat"));
        save(dbranlu, baLlb, 2025, Category.GENERAL, 1930, SRC_ORIGINAL_2025);
        save(dbranlu, baLlb, 2025, Category.EWS, 2727, SRC_ORIGINAL_2025);
        save(dbranlu, baLlb, 2025, Category.OBC, 4210, SRC_ORIGINAL_2025);
        save(dbranlu, baLlb, 2025, Category.SC, 12802, SRC_ORIGINAL_2025);
        save(dbranlu, baLlb, 2025, Category.ST, 19973, SRC_ORIGINAL_2025);

        College nlutAgartala = colleges.save(new College("NLUT Agartala", "Agartala"));
        save(nlutAgartala, baLlb, 2025, Category.GENERAL, 2855, SRC_ORIGINAL_2025);

        College rpnlu = colleges.save(new College("RPNLU Prayagraj", "Prayagraj"));
        save(rpnlu, baLlb, 2025, Category.GENERAL, 2469, SRC_ORIGINAL_2025);

        College iiuler = colleges.save(new College("IIULER Goa", "Goa"));
        save(iiuler, baLlb, 2025, Category.GENERAL, 2784, SRC_ORIGINAL_2025);
        save(iiuler, baLlb, 2025, Category.EWS, 3623, SRC_ORIGINAL_2025);
        save(iiuler, baLlb, 2025, Category.OBC, 5597, SRC_ORIGINAL_2025);
        save(iiuler, baLlb, 2025, Category.SC, 14412, SRC_ORIGINAL_2025);
        save(iiuler, baLlb, 2025, Category.ST, 21325, SRC_ORIGINAL_2025);

        College nuals = colleges.save(new College("NUALS Kochi", "Kochi"));
        save(nuals, baLlb, 2025, Category.GENERAL, 1346, SRC_ORIGINAL_2025);

    }

    private void save(College college, Program program, int year, Category category, int closingRank, String sourceUrl) {
        ClosingRank cr = new ClosingRank();
        cr.setCollege(college);
        cr.setProgram(program);
        cr.setYear(year);
        cr.setCategory(category);
        cr.setQuotaType(QuotaType.ALL_INDIA);
        cr.setClosingRank(closingRank);
        cr.setRoundLabel("final");
        cr.setSourceUrl(sourceUrl);
        closingRanks.save(cr);
    }
}
