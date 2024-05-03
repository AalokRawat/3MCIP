package com.company.atlassian.stage1.service;

import com.company.atlassian.stage1.Routing;
import com.company.atlassian.stage1.configuration.Configuration;
import com.company.atlassian.stage1.exception.RouteNotFoundException;

public class RoutingImplementation extends Routing {

    public RoutingImplementation(Configuration configuration) {
        super(configuration);
    }

    @Override
    public String execute(String path) throws RouteNotFoundException {
        if(!configuration.getRouteMap().containsKey(path)) {
            throw RouteNotFoundException.getDefaultException();
        }
        return configuration.getRouteMap().get(path);
    }


}
