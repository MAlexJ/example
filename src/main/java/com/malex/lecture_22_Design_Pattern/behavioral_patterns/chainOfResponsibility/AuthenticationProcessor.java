package com.malex.lecture_22_Design_Pattern.behavioral_patterns.chainOfResponsibility;

public abstract class AuthenticationProcessor {

    private AuthenticationProcessor nextProcessor;


    public AuthenticationProcessor(AuthenticationProcessor nextProcessor) {
        this.nextProcessor = nextProcessor;
    }

    public abstract boolean isAuthorized(AuthenticationProvider authProvider);

}
