import java.util.*;
// import java.util.stream.Collectors;
// import java.io.*;
import java.util.stream.*;
import java.util.stream.Stream;
import static java.util.stream.Collectors.*;

// Three types of data
// List<Integer>
// Stream<Integer>
// Stream<List<Integer>>

public class FlatMapDemo {
    public static void main(String[] args) {
        Stream<List<Integer>> integerListStream
	    = Stream.of(
                   Arrays.asList(1, 2), 
                   Arrays.asList(3, 4), 
                   Arrays.asList(5) );


    // integerStream      :: Stream<Integer>
    // integerListStream  :: Stream<List<Integer>>
    // flatMap :: (Stream A) -> (A -> Stream R) -> Stream R
    // flatMap :: (d :: Stream<List<Integer>>
    //         -> (stream :: List<Integer> -> Stream<Integer>)
    //     (flattening (Stream<Stream<Integer>>)
    //            -> Stream<Integer>
    //   =  flatten (d.fmap(stream))
    // stream :: [T] -> Stream T   (transform Collection into Stream)
    // fmap(stream)   :: Stream<List<T>> -> Stream<Stream<T>>


	Stream<Integer> integerStream
	    = integerListStream .flatMap(Collection::stream);
        integerStream.forEach(System.out::print); System.out.println();
	

	// Old version
	List<List<Integer>> integerLists
	    = Arrays.asList(
			Arrays.asList(1, 2),
			Arrays.asList(3, 4),
			Arrays.asList(5));

	List<Integer> flattened = new ArrayList<>();

	for (List<Integer> integerList : integerLists) {
	    flattened.addAll(integerList);  // addAll is real-flattening
	}

	for (Integer i : flattened)
	    System.out.print(i);
	System.out.println();

//  -------------------------------------

	String s = "ab cd 13 Fg\nAB ab  CD";
	
	String[] strArray = s.split("\\s+");
	// dumpArray(strArray);

	List<String> strList = Arrays.asList(strArray);
	List<String> strList2 = strList.stream()
	    .map(str -> str.split("\\s+")) // Stream<String[]>
	    .flatMap(Arrays::stream)       // Stream<String>
	    .distinct()                    // Stream<String>
	    .collect(toList());            // List<String>

	System.out.println(strList2);

	List<Character> strList4 = strList.stream()
	    .flatMap(str -> Stream.of(str.charAt(1)))  // Stream<Character>
	    .collect(toList());
	System.out.println(strList4);
    }

    static void dumpArray(String[] array) {
	for (int i = 0; i < array.length; i++)
	    System.out.format("array[%d] = %s%n", i, array[i]);
    }
}

