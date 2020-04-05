package com.malex.lecture_15_CompletableFuture.listCompletableFutures;

import com.google.common.collect.Lists;
import com.malex.lecture_15_CompletableFuture.listCompletableFutures.entity.Request;
import com.malex.lecture_15_CompletableFuture.listCompletableFutures.entity.Response;
import com.malex.lecture_15_CompletableFuture.listCompletableFutures.service.HttpService;
import lombok.extern.log4j.Log4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Log4j
public class RunApp {

    private List<Request> prepareRequests;
    private HttpService service;
    private ExecutorService executorService;

    {
        /*
        Returns the number of processors available to the Java virtual machine.
         */
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        executorService = Executors.newFixedThreadPool(availableProcessors);
        service = new HttpService();
        prepareRequests = Lists.newArrayList(
                new Request(1, "A"),
                new Request(2, "B"),
                new Request(3, "C"),
                new Request(4, "D"),
                new Request(5, "E"),
                new Request(6, "F"));
    }

    public static void main(String[] args) {
        RunApp app = new RunApp();
        app.runApp();

    }

    private void runApp() {
        List<CompletableFuture<Response>> futureList = new ArrayList<>();

        prepareRequests.forEach(request -> {
            CompletableFuture<Response> future =
                    CompletableFuture.supplyAsync(() ->
                            service.getHttpResponse(request), executorService)
                            .exceptionally(ex -> new Response(404, ex.getMessage()));
            futureList.add(future);
        });

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0]))
                // avoid throwing an exception in the join() call
                .exceptionally(ex -> {
                    log.error(ex);
                    return null;
                })
                // Returns the result value when complete,
                // or throws an (unchecked) exception if completed exceptionally.
                .join();

        futureList.forEach(r -> r.thenAccept(log::info));
        executorService.shutdown();
    }
}
