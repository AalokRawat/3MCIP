package com.company.atlassian.stage1.exception;

public class RouteNotFoundException extends Exception {

    private static final String MESSAGE = "No Route found for the provided path";
    private RouteNotFoundException(String message) {
        super(MESSAGE);
    }

    public static RouteNotFoundException getDefaultException() {
        return new RouteNotFoundException(MESSAGE);
    }
}
