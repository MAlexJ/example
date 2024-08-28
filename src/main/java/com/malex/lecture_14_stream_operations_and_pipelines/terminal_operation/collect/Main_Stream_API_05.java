package com.malex.lecture_14_stream_operations_and_pipelines.terminal_operation.collect;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A simple example of using the method collect of Stream API.
 * Receive a data in the form of  a collection.
 * For example  ArrayList or HashSe
 *
 * @author malex
 */
public class Main_Stream_API_05 {

   public static void main(String[] args) {

      String[] phones = new String[]{"iPhone 6 S", "Lumia 950", "Huawei Nexus 6P",
              "Samsung Galaxy S 6", "LG G 4", "Xiaomi MI 5",
              "ASUS Zenfone 2", "Sony Xperia Z5", "Meizu Pro 5",
              "Lenovo S 850"};

      //example 01
      use_collect_01(phones);

      //example 02
      use_collect_02(phones);

      //example 03
      use_collector_create_concrete_list(phones);

      //example 04
      use_collect_to_map(new Phone("iPhone 6 S", 54000),
              new Phone("Lumia 950", 45000),
              new Phone("Samsung Galaxy S 6", 40000),
              new Phone("LG G 4", 32000));
   }


   /**
    * Convert array to list.
    *
    * @param args incoming values
    */
   private static void use_collect_01(String... args) {
      print("EXAMPLE 01");

      List<String> result = Stream.of(args)
              .filter(p -> p.contains("o"))
              .collect(Collectors.toList());

      System.out.println(result);
      print();
   }

   /**
    * Convert stream to list
    *
    * @param args incoming values
    */
   private static void use_collect_02(String... args) {
      print("EXAMPLE 02");

      List<String> phones = new ArrayList<>(Arrays.asList(args));

      List<String> result = phones.stream()
              .filter(p -> p.matches("^[a-zA-Z0-9 ]{0,10}$"))
              .collect(Collectors.toList());

      System.out.println(result);

      print();
   }

   /**
    * Create the concrete list of using stream.
    * collect(Collectors.toCollection(LinkedList::new))
    *
    * @param args incoming values
    */
   private static void use_collector_create_concrete_list(String... args) {
      print("EXAMPLE 03");

      LinkedList<String> list = Stream.of(args)
              .filter(p -> p.length() > 10)
              .collect(Collectors.toCollection(LinkedList::new));

      System.out.println("Last element: " + list.getLast());
      print();
   }

   /**
    * Create Map<String, Integer>.
    * Collectors.toMap(Phone::getName, Phone::getPrice)
    *
    * @param phones incoming values
    */
   private static void use_collect_to_map(Phone... phones) {
      print("EXAMPLE 04");

      Map<String, Integer> map = Stream.of(phones)
              .collect(Collectors.toMap(Phone::getName, Phone::getPrice));

      map.forEach((k, v) -> System.out.println("KEY: " + k + "   VALUE: " + v));

      print();
   }


   /**
    * The second form of method "collect" has tree parameters.
    * 'supplier': creates a collection object
    * 'accumulator': adds an element to the collection
    * 'combiner': binary function that combines two objects
    */
   private static void use_collector_03() {
      print("EXAMPLE 05");


      print();
   }


   /**
    * Print the messages in a pretty form.
    * Prints only the first argument.
    *
    * @param args the message
    */
   private static void print(String... args) {
      StringBuilder sb = new StringBuilder();

      sb.append(" <<<<<<<<<<<<<<<<<< ");

      if (args.length > 0) {
         sb.append(args[0]);
      }

      sb.append(" >>>>>>>>>>>>>>>>>> ");

      if (args.length == 0) {
         sb.append("\n");
      }
      System.out.println(sb.toString());
   }

   /**
    * Simple the entity class
    */
   private static class Phone {

      private String name;
      private int price;

      Phone(String name, int price) {
         this.name = name;
         this.price = price;
      }

      String getName() {
         return name;
      }

      int getPrice() {
         return price;
      }
   }
}
