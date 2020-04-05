package com.malex.lecture_15_CompletableFuture.listCompletableFutures.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Response {
    private int statusCode;
    private String errMsg;
}