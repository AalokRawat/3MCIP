package com.company.atlassian.stage1.configuration;

import java.util.HashMap;
import java.util.Map;

public class Configuration {
    private final Map<String, String> routeMap = new HashMap<>();

    public void addRule(String path, String routeTo) {
        routeMap.put(path, routeTo);
    }

    public Map<String, String> getRouteMap() {
        return routeMap;
    }
}
