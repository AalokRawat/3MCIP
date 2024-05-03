package com.company.atlassian.stage2;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class RankingCalculatorTest {
    private RankingCalculator rankingCalculator = new RankingCalculator();

    @Test
    public void canGetSortedRanking() {
        List<List<String>> ballots = new ArrayList<>();

        ballots.add(getVote("A", "B", "C"));
        ballots.add(getVote("A", "C", "B"));
        ballots.add(getVote("A", "C", "B"));
        ballots.add(getVote("B", "C", "D"));

        List<TeamVotes> teamVotes = rankingCalculator.getResults(ballots);

        Assert.assertEquals(teamVotes.get(0).getTeam(), "A");
    }

    private ArrayList<String> getVote(String firstVote, String secondVote, String thirdVote) {
        return new ArrayList<>() {{
            add(firstVote);
            add(secondVote);
            add(thirdVote);
        }};
    }


}
