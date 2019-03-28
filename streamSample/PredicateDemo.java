import java.util.*;
import java.util.function.Predicate;

// Determine a true or false value for a given input

public class PredicateDemo {

    public static boolean isEvenOld(int num) { return (num % 2) == 0; }


    public static void main(String[] args) {

	List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

	for (int num : numbers) {
	    if (isEvenOld(num))
		System.out.print(num + " ");
	}

	// public interface Predicate<T>
        // public boolean test (T t)
	
	Predicate<Integer> isEven = new Predicate<Integer>()  {
	    @Override
	    public boolean test(Integer number) {
	        return (number % 2) == 0;
	    }
        };	
	for (int num : numbers) {
	    if (isEven.test(num))
		System.out.print(num + " ");
	}

	// Using java 8's higher-order function
	Predicate<Integer> isEven8 = s -> (s % 2) == 0;
	for (int num : numbers) {
	    if (isEven8.test(num))        
		System.out.print(num + " ");
        }
    }
}    
