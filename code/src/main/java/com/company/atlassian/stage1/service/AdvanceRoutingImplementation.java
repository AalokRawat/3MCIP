package com.company.atlassian.stage1.service;

import com.company.atlassian.stage1.configuration.RegexMatcher;
import com.company.atlassian.stage1.configuration.Configuration;
import com.company.atlassian.stage1.Routing;
import com.company.atlassian.stage1.exception.RouteNotFoundException;

public class AdvanceRoutingImplementation extends Routing {
    private final RegexMatcher regexMatcher;

    public AdvanceRoutingImplementation(Configuration configuration) {
        super(configuration);
        this.regexMatcher = new RegexMatcher();
        for(String path : configuration.getRouteMap().keySet()) {
            regexMatcher.addPath(path);
        }
    }

    @Override
    public void addRule(String path, String route) {
        super.addRule(path, route);
        regexMatcher.addPath(path);
    }

    @Override
    public String execute(String path) throws RouteNotFoundException {
        try {
            return configuration.getRouteMap().get(path);
        } catch (Exception e) {
            String regexPath = regexMatcher.match(path);
            return configuration.getRouteMap().get(regexPath);
        }
    }
}
