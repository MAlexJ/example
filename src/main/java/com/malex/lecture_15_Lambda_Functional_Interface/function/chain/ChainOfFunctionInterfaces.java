package com.malex.lecture_15_Lambda_Functional_Interface.function.chain;

import static com.malex.lecture_15_Lambda_Functional_Interface.function.chain.ChainOfFunctionInterfaces.ApiStatus.*;

import com.malex.utils.AbstractUtils;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import org.junit.Test;

public class ChainOfFunctionInterfaces extends AbstractUtils {

  private static final AtomicInteger counter = new AtomicInteger(3);

  @Test
  public void test() {
    handleError(
        () ->
            // 0. init context with access token
            initContextWithAccessToken()
                .andThen(ctx -> storeData(ACCESS_TOKEN_RESPONSE, ctx, NewAccountContext::getToken))
                // 2. call api to obtain rep id
                .andThen(ChainOfFunctionInterfaces::getRepId)
                // 3. store Rep id response
                .andThen(ctx -> storeData(REP_ID_RESPONSE, ctx, NewAccountContext::getRepId))
                // 4. prepare Open Account request
                .andThen(ChainOfFunctionInterfaces::prepareRequest)
                // 5. store Open Account request
                .andThen(
                    ctx ->
                        storeData(
                            OPEN_ACCOUNT_REQUEST, ctx, NewAccountContext::getOpenAccountRequest))
                // 6. call api to create new account
                .andThen(ChainOfFunctionInterfaces::createNewAccount)
                // 7. store Open Account response
                .andThen(
                    ctx ->
                        storeData(
                            OPEN_ACCOUNT_RESPONSE, ctx, NewAccountContext::getOpenAccountResponse))
                // 1. get token from cache or do api call
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
    printlnString("1. Initializing context:");
    return accessToken -> NewAccountContext.builder().token(accessToken).build();
  }

  // 1. Get access token
  private static String getAccessToken() {
    String token = UUID.randomUUID().toString();
    printlnString("2. Getting access token:", token);
    return token;
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
    return ctx.toBuilder().data(data).repId(repId).build();
  }

  // Prepare open account data
  private static NewAccountContext prepareRequest(NewAccountContext ctx) {
    // prepare logic
    return ctx.toBuilder().openAccountRequest("{ create new account: 12345 }").build();
  }

  // Create new account, API call
  private static NewAccountContext createNewAccount(NewAccountContext ctx) {
    String repId = ctx.getRepId();
    String token = ctx.getToken();
    String newAccountResponse = "200 Ok";
    return ctx.toBuilder().openAccountResponse(newAccountResponse).build();
  }

  // Store data to DB
  private static NewAccountContext storeData(
      ApiStatus status,
      NewAccountContext ctx, //
      Function<NewAccountContext, String> applyLoggedData) {
    printlnString(
        Integer.toString(counter.incrementAndGet()),
        ".",
        status.getName() + ":" + applyLoggedData.apply(ctx));
    return ctx;
  }

  // Store data to DB
  private static void storeData(ApiStatus status, String message) {
    printlnString("Store ctx - " + message + ", type - " + status.getName());
  }

  @Getter
  @ToString
  @Builder(toBuilder = true)
  private static class NewAccountContext {
    private String token;
    private String repId;
    private String data;

    private String openAccountRequest;
    private String openAccountResponse;
  }

  @Getter
  enum ApiStatus {
    ACCESS_TOKEN_RESPONSE("FOUNKEEPER ACCESS TOKEN RESPONSE"), //
    REP_ID_RESPONSE("FOUNKEEPER INTERNAL REP ID RESPONSE"), //
    OPEN_ACCOUNT_REQUEST("FOUNKEEPER OPEN ACCOUNT REQUEST"), //
    OPEN_ACCOUNT_RESPONSE("FOUNKEEPER OPEN ACCOUNT RESPONSE"), //
    ERROR("FOUNKEEPER API ERROR");

    private final String name;

    ApiStatus(String name) {
      this.name = name;
    }
  }
}
