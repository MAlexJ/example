package com.malex.lecture_22_Design_Pattern.Behavioral.chainOfResponsibility.impl;

import com.malex.lecture_22_Design_Pattern.Behavioral.chainOfResponsibility.AuthenticationProcessor;
import com.malex.lecture_22_Design_Pattern.Behavioral.chainOfResponsibility.AuthenticationProvider;

public class OAuthProcessor extends AuthenticationProcessor {

    public OAuthProcessor(AuthenticationProcessor nextProcessor) {
        super(nextProcessor);
    }

    @Override
    public boolean isAuthorized(AuthenticationProvider authProvider) {
        return false;
    }
}
