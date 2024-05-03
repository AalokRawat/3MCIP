package com.company.atlassian.stage1;

import com.company.atlassian.stage1.configuration.Configuration;
import com.company.atlassian.stage1.exception.RouteNotFoundException;

public abstract class Routing {

    protected Configuration configuration;

    protected Routing(Configuration configuration) {
        this.configuration = configuration;
    }

    public void addRule(String path, String route) {
        this.configuration.addRule(path, route);
    }

    public abstract String execute(String path) throws RouteNotFoundException;
}
