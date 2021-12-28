package com.malex.lecture_22_Design_Pattern.behavioral_patterns.chainOfResponsibility.impl;

import com.malex.lecture_22_Design_Pattern.behavioral_patterns.chainOfResponsibility.AuthenticationProcessor;
import com.malex.lecture_22_Design_Pattern.behavioral_patterns.chainOfResponsibility.AuthenticationProvider;

public class ValidationCredentialsProcessors extends AuthenticationProcessor {

    public ValidationCredentialsProcessors(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        return false;
    }
}
