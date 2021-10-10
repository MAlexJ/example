package com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern.cache;

import com.malex.lecture_22_Design_Pattern.example_02_Service_Locator.pattern.service.MessagingService;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Predicate;

public class Cache {

    private Set<MessagingService> services;

    public Cache() {
        services = new HashSet<>();
    }

    public MessagingService getService(String serviceName) {
        return services.stream()
                .filter(comparePredicate(serviceName))
                .findFirst()
                .orElse(null);
    }

    public void addService(MessagingService newService) {
        services.add(newService);
    }

    private Predicate<MessagingService> comparePredicate(String serviceName) {
        return service -> service.getServiceName().equalsIgnoreCase(serviceName);
    }
}
