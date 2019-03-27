// Lmabda are used primarily to define inline implementatin of a functional interface,
// i.e. an interface with a single method only
// Lambda eliminates the need of anonymous class and gives a very simple yet
// powerful functional programming capability to Java

public class FunInterface2 {
    
   public static void main(String args[]) {
      FunInterface2 tester = new FunInterface2();
		
      //with type declaration
      MathOperation addition = (int a, int b) -> a + b;
		
      //with out type declaration
      MathOperation subtraction = (a, b) -> a - b;
		
      //with return statement along with curly braces
      MathOperation multiplication = (int a, int b) -> { return a * b; };
		
      //without return statement and without curly braces
      MathOperation division = (int a, int b) -> a / b;
		
      System.out.println("10 + 5 = " + tester.operate(10, 5, addition));
      System.out.println("10 - 5 = " + tester.operate(10, 5, subtraction));
      System.out.println("10 x 5 = " + tester.operate(10, 5, multiplication));
      System.out.println("10 / 5 = " + tester.operate(10, 5, division));
		
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
   interface MathOperation { int operation(int a, int b);  }

   @FunctionalInterface
   interface GreetingService { void sayMessage(String message); }

   private int operate(int a, int b, MathOperation mathOperation) {
      return mathOperation.operation(a, b);
   }
}
