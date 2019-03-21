// Lmabda are used primarily to define inline implementatin of a functional interface,
// i.e. an interface with a single method only
// Lambda eliminates the need of anonymous class and gives a very simple yet
// powerful functional programming capability to Java

import java.util.function.*;
public class FunInterface2 {
    
   public static void main(String args[]) {
      FunInterface2 tester = new FunInterface2();
		

      BiFunction<Integer, Integer, Integer > addition = (x, y) -> x+y;
		
      //with out type declaration
      BinaryOperator<Integer> subtraction = (x, y) -> x-y;
		
      //with return statement along with curly braces
      BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x*y;
		
      //without return statement and without curly braces
      BinaryOperator<Integer> division = (x, y) -> x/y;
		
      System.out.println("10 + 5 = " + addition.apply(10,5));
      System.out.println("10 - 5 = " + subtraction.apply(10,5));
      System.out.println("10 x 5 = " + multiplication.apply(10,5));
      System.out.println("10 / 5 = " + division.apply(10,5));
		
      //without parenthesis
      GreetingService greetService1 = message ->
      System.out.println("Hello " + message);
		
      //with parenthesis
      GreetingService greetService2 = (message) ->
      System.out.println("Hello " + message);
		
      greetService1.sayMessage("Mahesh");
      greetService2.sayMessage("Suresh");
   }
   @FunctionalInterface
   interface GreetingService { void sayMessage(String message); }
   }
