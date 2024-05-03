package com.company.atlassian.stage2;

import java.util.ArrayList;
import java.util.List;

public class TeamWhichHasFirstPositionWin implements ConflictResolver {

    public List<String> execute(List<List<String>> ballots, List<String> teams) {
        if(teams.size()>2) {
            throw new IllegalStateException();
        }
        String team1 = teams.get(0);
        String team2 = teams.get(1);

        List<String> conflictResolvedWinner = new ArrayList<>();

        for(List<String> ballot : ballots) {
            if(conflictResolvedWinner.size()==1 &&
                    (ballot.get(0).equals(team1) || ballot.get(0).equals(team2)) &&
                    !conflictResolvedWinner.get(0).equals(ballot.get(0))) {
                throw new IllegalStateException();
            }

            if(ballot.get(0).equals(team1) || ballot.get(0).equals(team2)) {
                conflictResolvedWinner.add(ballot.get(0));
            }
        }
        return null;
    }
}
