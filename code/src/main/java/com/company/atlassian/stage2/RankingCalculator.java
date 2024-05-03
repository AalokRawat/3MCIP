package com.company.atlassian.stage2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class RankingCalculator {

    /**
     * Process a list of ballots, and return all candidates sorted in descending order by their total number of points.
     * voter 1 A B C
     * voter 2 A C B
     * voter 3 A C B
     * voter 4 B C D
     *
     *
     * * First candidate to the largest number of points wins.
     * * First candidate with the most 1st place votes wins.
     */

    public static void main(String[] args) {

    }

    List<TeamVotes> getResults(List<List<String>> ballots) {


        Map<String, Integer> teamToVotes = new HashMap<>();

        for(List<String> ballot : ballots) {
            int points=3;
            for(int i=0; i<ballot.size(); i++) {
                teamToVotes.putIfAbsent(ballot.get(i), 0);
                teamToVotes.put(ballot.get(i), teamToVotes.get(ballot.get(i))+points--);
            }
        }

        List<TeamVotes> list = new ArrayList<>();
        for(Map.Entry<String, Integer> entry : teamToVotes.entrySet()) {
            list.add(new TeamVotes(entry.getKey(), entry.getValue()));
        }

        Collections.sort(list, (a, b) -> b.votes-a.votes);

        List<TeamVotes> conflicts = new ArrayList<>();

        return list;
    }
}

class TeamVotes{
    String team;
    Integer votes;

    public TeamVotes(String team, Integer votes) {
        this.team = team;
        this.votes = votes;
    }

    public String getTeam() {
        return team;
    }

    public Integer getVotes() {
        return votes;
    }
}