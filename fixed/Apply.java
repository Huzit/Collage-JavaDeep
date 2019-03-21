import java.util.function.*;

class Apply {
    public static void main(String args[]) { 
        Function<Integer,Integer>  square = x -> x*x;
        int result = square.apply(5);
        System.out.println(result);

	BiFunction<Integer,Integer,Integer> max = (x,y) -> x>y ? x:y;
	result = max.apply(3,5);
	System.out.println("Max is " + result);

	// Consumer in Function
	// void type is not allowed in function type definition
	// Function<Integer,Void> prnt = x -> System.out.println("Consumer " + x);
	// void prnt.apply(100);
    }
}

