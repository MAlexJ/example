package com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.impl;

import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.MessagingService;
import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.ServiceName;

public class EmailService implements MessagingService {

    @Override
    public String getMessageBody() {
        return "email message";
    }

    @Override
    public String getServiceName() {
        return ServiceName.EMAIL_SERVICE.getName();
    }
}
