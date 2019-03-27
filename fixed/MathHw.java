
import java.util.function.*;

public class FunInterface2 {
    
   public static void main(String args[]) {

      BiFunction<Integer, Integer, Integer > addition = (x, y) -> x+y;

      BinaryOperator<Integer> subtraction = (x, y) -> x-y;

      BiFunction<Integer, Integer, Integer> multiplication = (x, y) -> x*y;
		
      BinaryOperator<Integer> division = (x, y) -> x/y;
		
      System.out.println("10 + 5 = " + addition.apply(10,5));
      System.out.println("10 - 5 = " + subtraction.apply(10,5));
      System.out.println("10 x 5 = " + multiplication.apply(10,5));
      System.out.println("10 / 5 = " + division.apply(10,5));

      Consumer<String> greetService1 = message -> System.out.println("Hello"+message);
      Consumer<String> greetService2 = message -> System.out.println("Hello"+message);
		
      greetService1.accept("Mahesh");
      greetService2.accept("Suresh");
   }
}
