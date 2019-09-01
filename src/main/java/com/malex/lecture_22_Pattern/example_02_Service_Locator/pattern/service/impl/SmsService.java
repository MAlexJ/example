package com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.impl;

import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.MessagingService;
import com.malex.lecture_22_Pattern.example_02_Service_Locator.pattern.service.ServiceName;

public class SmsService implements MessagingService {

    @Override
    public String getMessageBody() {
        return "sms message";
    }

    @Override
    public String getServiceName() {
        return ServiceName.SMS_SERVICE.getName();
    }
}
