package com.malex.lecture_15_Lambda.example_01;

/**
 * Simple example lambda and local variable.
 * Use class-level variables:
 *
 * @author maelx
 */
class Lambda_Main_04 {

   //use class-level variables:
   private static int x = 10;
   private static int y = 20;

   public static void main(String[] args) {

      // use class-level variables:
      System.out.println("Before, x= " + x); // 30 - значение x изменилось
      Operation_02 op = () -> {
         x = 30;
         return x + y;
      };
      System.out.println("Lambda -> calculate = " + op.calculate()); // 50
      System.out.println("After, x= " + x + "\n"); // 30 - значение x изменилось


      // local method-level variables:
      int a = 12;
      int b = 7;
      System.out.println("Before, a= " + a);
      op = () -> {
         //  a=100; - так нельзя сделать
         return a + b;
      };
      // a=100;  - так тоже нельзя
      System.out.println("op.calculate() = " + op.calculate() + "\n"); // 100
      System.out.println("After, a= " + a);

      //Blocks of code in lambda expressions
      Lambda_02 labmda = (x, y) -> {
         if (x == 0)
            return 0;
         else {
            return x / y;
         }
      };
      System.out.println("labmda.calculate(0, 20) = " + labmda.calculate(0, 20)); // 100
      System.out.println("labmda.calculate(50, 20) = " + labmda.calculate(50, 20)); // 100
   }
}

/**
 * Functional interface
 */
interface Operation_02 {
   int calculate();
}

interface Lambda_02 {
   int calculate(int x, int y);
}