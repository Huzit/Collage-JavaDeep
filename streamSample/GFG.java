// Java code for Stream flatMap 
// (Function mapper) to get a stream by 
// replacing the stream with a mapped 
// stream by applying the provided mapping function. 
import java.util.*; 
import java.util.stream.Stream; 
  
class GFG {
    public static void main(String[] args)  { 
  
        // Creating a List of Strings 
        List<String> list = Arrays.asList("Geeks", "GFG", 
                                 "GeeksforGeeks", "gfg"); 
  
        // Using Stream flatMap(Function mapper) 
        list.stream().flatMap(str -> Stream.of(str.charAt(2)))
	             .forEach(System.out::println); 
    } 
}
