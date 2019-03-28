import java.util.stream.*;

public class StreamTest {
    public static void main(String[] args) {
	Stream<Double> ints = Stream.of(1.1, 2.2, 3.3);
	ints.filter(d -> d > 1.3)
	    .filter(d -> d > 2.3)
	    .forEach(System.out::println);

	Stream<Integer> strm = Stream.of(1,2,3,4);
	// strm.filter(d -> d>3); // error 
	strm.filter(d -> d>2).forEach(System.out::println);
	// error strm.filter(d -> d>3).forEach(System.out::println);

	Stream<Double> strm2 = Stream.of(1.1, 2.2, 3.3);
	strm2 = strm2.filter(d -> d > 1.3);  // returned by previous operation
	strm2.filter(d -> d > 2.3)     
	    .forEach(System.out::println);
    }
}
