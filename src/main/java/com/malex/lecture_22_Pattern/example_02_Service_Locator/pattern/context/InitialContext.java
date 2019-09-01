package com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.context;

import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.ServiceName;
import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.impl.EmailService;
import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.impl.SmsService;

public class InitialContext {

    public Object lookup(String serviceName) {
        switch (ServiceName.findServiceName(serviceName)) {
            case EMAIL_SERVICE:
                return new EmailService();
            case SMS_SERVICE:
                return new SmsService();
            default:
                throw new RuntimeException("Service not found");
        }
    }
}
