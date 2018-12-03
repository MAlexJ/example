package com.malex.lecture_15_CompletableFuture.exampleSimple;

import java.util.concurrent.CompletableFuture;
import org.apache.log4j.Logger;

public class SimpleExample {

  private static final Logger LOG = Logger.getLogger(SimpleExample.class);

  public static void main(String[] args) {

//    CompletableFuture.supplyAsync(()-> readFile())
//        .complete(result-> LOG.debug(result));
  }

  private static <U> U readFile()
  {


    return null;
  }
}
