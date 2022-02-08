package com.malex.lecture_22_Design_Pattern.DependencyInjection.example_02_Service_Locator;

import com.malex.lecture_22_Design_Pattern.DependencyInjection.example_02_Service_Locator.pattern.ServiceLocator;
import com.malex.lecture_22_Design_Pattern.DependencyInjection.example_02_Service_Locator.pattern.service.MessagingService;
import com.malex.lecture_22_Design_Pattern.DependencyInjection.example_02_Service_Locator.pattern.service.ServiceName;
import lombok.extern.log4j.Log4j;

@Log4j
public class ServiceLocatorApp {

    public static void main(String[] args) {
        log.info("Service Locator Pattern");

        MessagingService service = ServiceLocator.getService(ServiceName.EMAIL_SERVICE.getName());
        log.info(service.getMessageBody());

        service = ServiceLocator.getService(ServiceName.SMS_SERVICE.getName());
        log.info(service.getMessageBody());
    }
}
