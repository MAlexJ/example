package com.malex.lecture_15_Lambda.function;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder(toBuilder = true)
public class NewAccountContext {
    private String token;
    private String repId;
    private String data;

    private String openAccountRequest;
    private String openAccountResponse;
}
