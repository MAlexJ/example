package com.malex.lecture_15_Lambda.function;

import lombok.extern.java.Log;

import java.util.UUID;
import java.util.function.Function;

import static com.malex.lecture_15_Lambda.function.ApiStatus.*;

@Log
public class FunctionInterfaceSample {

    public static void main(String[] args) {
        handleError(() ->
                // 1. init context with access token
                initContextWithAccessToken()
                        .andThen(ctx -> storeData(ACCESS_TOKEN_RESPONSE, ctx, NewAccountContext::getToken))
                        // 2. call api to obtain rep id
                        .andThen(FunctionInterfaceSample::getRepId)
                        // 3. store Rep id response
                        .andThen(ctx -> storeData(REP_ID_RESPONSE, ctx, NewAccountContext::getRepId))
                        // 4. prepare Open Account request
                        .andThen(FunctionInterfaceSample::prepareRequest)
                        // 5. store Open Account request
                        .andThen(ctx -> storeData(OPEN_ACCOUNT_REQUEST, ctx, NewAccountContext::getOpenAccountRequest))
                        // 6. call api to create new account
                        .andThen(FunctionInterfaceSample::createNewAccount)
                        // 7. store Open Account response
                        .andThen(ctx -> storeData(OPEN_ACCOUNT_RESPONSE, ctx, NewAccountContext::getOpenAccountResponse))
                        // 0. get token from cache or do api call
                        .apply(getAccessToken()));
    }

    // base handle error
    private static void handleError(Runnable r) {
        try {
            r.run();
        } catch (Exception ex) {
            String errMsg = "API call error - " + ex.getMessage();
            storeData(ERROR, errMsg);
            throw new RuntimeException(errMsg, ex);
        }
    }


    // Add access token to context
    private static Function<String, NewAccountContext> initContextWithAccessToken() {
        return accessToken -> NewAccountContext.builder()
                .token(accessToken)
                .build();
    }


    // 1. Get access token
    private static String getAccessToken() {
        return UUID.randomUUID().toString();
    }


    // 3. Data RepId from API
    private static NewAccountContext getRepId(NewAccountContext ctx) {
        // 3.1 get token
        String accessToken = ctx.getToken();
        // 3.2 get data from DB
        String data = "DATA FROM DB";
        // 3.3. call API and get response
        String repIdResponse = "201 Ok";
        // 3.4 parse response and get repId
        String repId = "RepId";
        return ctx.toBuilder()
                .data(data)
                .repId(repId)
                .build();
    }


    // Prepare open account data
    private static NewAccountContext prepareRequest(NewAccountContext ctx) {
        // prepare logic
        return ctx.toBuilder()
                .openAccountRequest("{ create new account: 12345 }")
                .build();
    }


    // Create new account, API call
    private static NewAccountContext createNewAccount(NewAccountContext ctx) {
        String repId = ctx.getRepId();
        String token = ctx.getToken();
        String newAccountResponse = "200 Ok";
        return ctx.toBuilder()
                .openAccountResponse(newAccountResponse)
                .build();
    }

    // Store data to DB
    private static NewAccountContext storeData(ApiStatus status, NewAccountContext ctx,
                                               Function<NewAccountContext, String> applyLoggedData) {
        log.info(status.getName() + ":" + applyLoggedData.apply(ctx));
        return ctx;
    }

    // Store data to DB
    private static void storeData(ApiStatus status, String message) {
        log.info("Store ctx - " + message + ", type - " + status.getName());
    }
}