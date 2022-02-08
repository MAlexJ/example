package com.malex.lecture_22_Design_Pattern.DependencyInjection.example_02_Service_Locator.pattern.service;

import lombok.Getter;

import java.util.stream.Stream;

public enum ServiceName {
    SMS_SERVICE("SmsService"),
    EMAIL_SERVICE("EmailService");

    @Getter
    private String name;

    ServiceName(String serviceName) {
        this.name = serviceName;
    }

    public static ServiceName findServiceName(String name) {
        return Stream.of(ServiceName.values())
                .filter(sName -> sName.name.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Service name is not found!"));
    }
}