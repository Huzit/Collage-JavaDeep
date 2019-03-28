import java.util.*;
import java.util.stream.*;
import java.io.*;
import java.nio.file.Paths;
import java.nio.*;

class Trans {

    public enum TransType { GROCERY, PERSONAL, SCHOOL }    

    TransType type;
    int id;
    int value;

    Trans(TransType t, int i, int v) {
	this.type = t;   this.id = i;	this.value = v;
    }

    public TransType getType() { return this.type; }
    public int getId() { return this.id; }
    public int getValue() { return this.value; }
}

public class Urma {

    public static void main(String[] args) {
        
	List<Trans> transactions = new ArrayList<>();
	List<Trans> groceryTransactions = new ArrayList<>();
	Trans t1 = new Trans(Trans.TransType.GROCERY, 1, 100);
	Trans t2 = new Trans(Trans.TransType.PERSONAL, 2, 1100);
	Trans t3 = new Trans(Trans.TransType.GROCERY, 3, 900);
	Trans t4 = new Trans(Trans.TransType.SCHOOL, 4, 200);
	Trans t5 = new Trans(Trans.TransType.PERSONAL, 5, 500);
	Trans t6 = new Trans(Trans.TransType.GROCERY, 6, 300);

	transactions.add(t1);
	transactions.add(t2);
	transactions.add(t3);
	transactions.add(t4);
	transactions.add(t5);
	transactions.add(t6);

	for (Trans t : transactions) {
	    if(t.getType() == Trans.TransType.GROCERY) {
		groceryTransactions.add(t);
	    }
	}

	// Printing for test
	for (Trans t : transactions) {System.out.println(t.getType()); }
	for (Trans t : groceryTransactions) {System.out.println(t.getType());}
System.out.println("----------------------------------------------");
	Collections.sort(groceryTransactions, new Comparator<Trans>() {
		public int compare(Trans a, Trans b) {
		    return (a.getValue() <  b.getValue()) ?  -1 :
			(a.getValue() == b.getValue()) ? 0 : 1; 
		}
	    } );

	List<Integer> transactionIds = new ArrayList<>();
	for (Trans t : groceryTransactions) {
	    transactionIds.add(t.getId() );
	}

	List<Integer> transactionIds2 =
	    transactions.parallelStream()
 	                .filter(t -> t.getType() == Trans.TransType.GROCERY)
     	                .sorted(Comparator.comparing(t -> t.value))
	                .map(Trans::getId)
	                //.forEach(x -> System.out.println(x)); 
	                .collect(Collectors.toList());
		     
	for (Integer t : transactionIds2) {System.out.println(t); }
System.out.println("----------------------------------------------");
	boolean expensive =
	    transactions.stream()
	    .allMatch(t -> t.getValue() < 2000);
	System.out.println("expensive is " + expensive);
System.out.println("----------------------------------------------");
	Optional<Trans> opt =
	    transactions.stream()
	    .filter(t -> t.getType() == Trans.TransType.GROCERY)
	    .findAny();
   	    // .ifPresent(this::print);
	    // .ifPresent(System.out::println);

	// System.out.println(opt);

	List<String> words = Arrays.asList("Korea", "Java", "Computer");
	List<Integer> wordLengths =
	    words.stream()
	         .map(String::length)
	         .collect(Collectors.toList());
	
	for (Integer t : wordLengths) {System.out.println(t); }
	
	 words.stream()
	       .filter(x -> x.length() > 4)
               .forEach(x -> System.out.println(x)); 
System.out.println("----------------------------------------------");
	// int sum = integers.reduce(0, (a, b) -> a+b);
        int statement =
	    transactions.stream()
	    .mapToInt(x -> x.value)
	    .sum();

	System.out.println("Total value is " + statement);
System.out.println("----------------------------------------------");
	int sumExpensive = transactions.stream()
	                     .filter(t -> t.getValue() > 300)
                             .map(Trans::getValue)
                             .reduce(0, Integer::sum);
	
	System.out.println("sumExpensive is " + sumExpensive);
System.out.println("----------------------------------------------");
	IntStream oddNumbers =
	    IntStream.rangeClosed(10,30)
    	             .filter(n -> n % 2 == 1);

	IntStream.of(1, 2, 3, 4, 8, 9, 6)
                 .map(i -> i % 2 != 0 ? i + 7 : i)
                 .forEach(System.out::println);
	System.out.println("----------------------------------------------");
	// Creating a stream from a value
	Stream<Integer> numbersFromValues = Stream.of(1,2,3,4);
	int[] numbers = {1,2,3,4};
	IntStream numbersFromArray = Arrays.stream(numbers);

	// Convert a file into a stream of lines using Files.lines
	// int numbersOfLines =
	// File.lines(Paths.get("~/.bashrc"), Charset.defaultCharset())
	//  .count();

	Stream<Integer> numbers2 = Stream.iterate(0, n -> n + 10);
	numbers2.limit(5).forEach(System.out::println);
    }
}
