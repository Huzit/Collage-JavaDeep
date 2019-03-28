import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;
import java.util.*;
import java.util.stream.*;

public class FlatMap1 {
public static void main(String[] args){

    Stream<String> words = Stream.of("Java", "Magazine", "is", "the", "best");

    Map<String, Long> letterToCount = words
	.map(w -> w.split(""))
	.flatMap(Arrays::stream)
	.collect(groupingBy(identity(), counting()));

    System.out.print(letterToCount +"\n");

}
}
