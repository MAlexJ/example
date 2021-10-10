package com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern;

import com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern.cache.Cache;
import com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern.context.InitialContext;
import com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern.service.MessagingService;

public class ServiceLocator {

    private ServiceLocator() {
        // not use
    }

    private static Cache cache;

    static {
        cache = new Cache();
    }

    public static MessagingService getService(String jndiName) {
        MessagingService service = cache.getService(jndiName);
        if (service != null) {
            return service;
        }

        InitialContext context = new InitialContext();
        MessagingService newService = (MessagingService) context.lookup(jndiName);
        cache.addService(newService);

        return newService;
    }
}
