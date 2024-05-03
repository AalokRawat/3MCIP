package com.company.atlassian.stage1.configuration;

import com.company.atlassian.stage1.exception.RouteNotFoundException;

import java.util.HashMap;
import java.util.Map;

public class RegexMatcher {
    public static final String SLASH = "/";
    public static final String WILDCARD = "*";
    private Trie trie = new Trie();

    public void addPath(String path) {
        String[] keywords = path.split(SLASH);

        Trie traverse = trie;
        for(String keyword : keywords) {
            if(keyword.isEmpty()) {
                continue;
            }
            traverse.nodes.putIfAbsent(keyword, new Trie());
            traverse = traverse.nodes.get(keyword);
        }
    }

    public String match(String path) throws RouteNotFoundException {
        String[] keywords = path.split(SLASH);

        Trie traverse = trie;
        StringBuilder matchedPath= new StringBuilder();

        for(String keyword : keywords) {
            if(keyword.isEmpty()) {
                continue;
            }
            if(traverse.nodes.containsKey(WILDCARD)) {
                matchedPath.append(SLASH + WILDCARD);
                return matchedPath.toString();
            }
            if(traverse.nodes.containsKey(keyword)) {
                matchedPath.append(SLASH + keyword);
                traverse = traverse.nodes.get(keyword);
            } else {
                throw RouteNotFoundException.getDefaultException();
            }
        }

        return matchedPath.toString();
    }


}

class Trie {
    Map<String, Trie> nodes = new HashMap<>();
}