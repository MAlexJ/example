package com.malex.lecture_15_CompletableFuture.listCompletableFutures.service;

import com.malex.lecture_15_CompletableFuture.listCompletableFutures.entity.Request;
import com.malex.lecture_15_CompletableFuture.listCompletableFutures.entity.Response;
import lombok.extern.log4j.Log4j;

import java.util.UUID;

@Log4j
public class HttpService {

    public Response getHttpResponse(Request request) {

        if (request.getId() == 2) {
            throw new RuntimeException();
        }

        if (request.getId() == 4) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                Thread.currentThread().interrupt();
            }
        }

        return new Response(request.getId(), UUID.randomUUID().toString());
    }
}
