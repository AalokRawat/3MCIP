package com.company.atlassian.karot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FindStartAndEndVertex {
    public static void main(String[] args) {
        String[][] edges = {
                {"A", "B"},
                {"A", "C"},
                {"B", "D"},
                {"C", "E"},
                {"C", "F"},
                {"G", "C"},
                {"G", "H"},
                {"H", "I"},
                {"J", "K"}
        };
        Graph g = new Graph();
        for(String[] edge : edges) {
            g.addEdge(edge[0], edge[1]);
        }
        List<List<String>> startAndEnd = g.getStartAndEndVertex();
        System.out.println(startAndEnd.toString());
    }
}

class Node {
    Set<String> incoming = new HashSet<>();
    Set<String> outgoing = new HashSet<>();
}

class Graph {
    Map<String, Node> nodes = new HashMap<>();

    public void addEdge(String a, String b) {
        nodes.computeIfAbsent(a, key ->nodes.put(key, new Node()));
        nodes.computeIfAbsent(b, key ->nodes.put(key, new Node()));
        
        nodes.get(a).outgoing.add(b);
        nodes.get(b).incoming.add(a);
    }

    public List<List<String>> getStartAndEndVertex() {
        List<List<String>> list = new ArrayList<>();
        for(String key : nodes.keySet()) {
            if(nodes.get(key).incoming.isEmpty()) {
                List<String> list1 = new ArrayList<>();
                list1.add(key);
                list1.addAll(getEndVertexFor(key));
                list.add(list1);
            }
        }
        return list;
    }

    private List<String> getEndVertexFor(String vertex) {
        List list = new ArrayList();
        getEndVertexFor(vertex, list);
        return list;
    }

    private void getEndVertexFor(String vertex, List list) {
        if(nodes.get(vertex).outgoing.isEmpty()) {
            list.add(vertex);
            return;
        }

        for(String v : nodes.get(vertex).outgoing) {
            getEndVertexFor(v, list);
        }
    }
}