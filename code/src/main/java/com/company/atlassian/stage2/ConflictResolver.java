package com.company.atlassian.stage2;

import java.util.List;

public interface ConflictResolver {

    List<String> execute(List<List<String>> ballots, List<String> teams);
}
