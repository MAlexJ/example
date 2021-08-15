package com.malex.lecture_15_Lambda.function;

import lombok.Getter;

public enum ApiStatus {
    ACCESS_TOKEN_RESPONSE("FOUNKEEPER ACCESS TOKEN RESPONSE"),
    REP_ID_RESPONSE("FOUNKEEPER INTERNAL REP ID RESPONSE"),
    OPEN_ACCOUNT_REQUEST("FOUNKEEPER OPEN ACCOUNT REQUEST"),
    OPEN_ACCOUNT_RESPONSE("FOUNKEEPER OPEN ACCOUNT RESPONSE"),
    ERROR("FOUNKEEPER API ERROR");

    @Getter
    private String name;

    ApiStatus(String name) {
        this.name = name;
    }
}
