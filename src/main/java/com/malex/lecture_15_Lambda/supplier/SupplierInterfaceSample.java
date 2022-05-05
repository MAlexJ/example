package com.malex.lecture_15_Lambda.supplier;

import lombok.extern.java.Log;

import java.util.UUID;
import java.util.function.Supplier;

@Log
public class SupplierInterfaceSample {

    public static void main(String[] args) {
        Supplier<String> getToken = () -> {
            String apiCall = UUID.randomUUID().toString();
            return apiCall;
        };

        String token = getToken.get();
        log.info("token - " + token);
    }

}
