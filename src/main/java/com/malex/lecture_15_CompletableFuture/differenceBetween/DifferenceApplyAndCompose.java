package com.malex.lecture_15_CompletableFuture.differenceBetween;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

/**
 * Difference Between thenApply() and thenCompose()
 *
 * <p>Method: 'thenApply()'
 *
 * <p>This method is used for working with a result of the previous call. However, a key point to
 * remember is that the return type will be combined of all calls. So this method is useful when we
 * want to transform the result of a CompletableFuture call
 *
 * <p>Method: thenCompose()
 *
 * <p>The thenCompose() method is similar to thenApply() in that both return a new Completion Stage.
 * However, thenCompose() uses the previous stage as the argument. It will flatten and return a
 * Future with the result directly, rather than a nested future as we observed in thenApply(). So if
 * the idea is to chain CompletableFuture methods then it’s better to use thenCompose()
 *
 * <p>.
 */
@Log4j
public class DifferenceApplyAndCompose {

  private static Supplier<Response> supplyResponse = Response::new;

  public static void main(String[] args) throws ExecutionException, InterruptedException {
    DifferenceApplyAndCompose clazz = new DifferenceApplyAndCompose();
    clazz.exampleThenApply();
  }

  /**
   * However, a key point to remember is that the return type will be combined of all calls. This
   * method is useful when we want to transform the result of a CompletableFuture cal
   */
  private void exampleThenApply() throws ExecutionException, InterruptedException {

    // get User
    CompletableFuture<User> userCompletableFuture =
        CompletableFuture.completedFuture(new User("Max", "555"));

    // get Credential
    CompletableFuture<Credential> credentialCompletableFuture =
        CompletableFuture.completedFuture(new Credential("12345"));

    // main future
    CompletableFuture<Response> future =
        CompletableFuture.supplyAsync(supplyResponse)
            .thenCombine(userCompletableFuture, this::addUser)
            .thenCombine(credentialCompletableFuture, this::addCredential);

    log.debug(future.get());
  }

  private Response addCredential(Response response, Credential credential) {
    response.setCredential(credential);
    return response;
  }

  private Response addUser(Response response, User user) {
    response.setUser(user);
    return response;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @ToString
  private static class Response {
    private User user;
    private Credential credential;
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  private static class User {
    private String name;
    private String phone;

    @Override
    public String toString() {
      return "[name=" + name + ", phone=" + phone + "]";
    }
  }

  @Getter
  @Setter
  @NoArgsConstructor
  @AllArgsConstructor
  private static class Credential {
    private String password;

    @Override
    public String toString() {
      return "[pwd=" + password + "]";
    }
  }
}
