import java.util.*;
// import java.util.stream.Collectors;
// import java.io.*;
import java.util.stream.*;
import java.util.function.Consumer;
import java.util.function.Supplier;


public class Winterberg {
    public static void main(String[] args) {
	List<String> myList = 
	    Arrays.asList("a1", "a2", "b1", "c2", "c1");
	
	System.out.println(myList);
	
	// forEach(String e : myList)
	for(String e : myList)
	    System.out.print(e + "   " );
	System.out.println();

	// The above statement is translated into the followings
      	for (Iterator iter = myList.iterator(); iter.hasNext();) {
	    Object obj = iter.next();          // a value is extracted
	    System.out.print(obj + "   ");
	}
	System.out.println();
	System.out.println("-------- 1 ----------------------------------");

	myList
	    .stream()
	    .filter(s -> s.startsWith("c"))
	    .map(String::toUpperCase)
	    .sorted()
	    .forEach(System.out::println); // C1, C2

	System.out.println("---------- 2 ---------------------------------- ");

	Arrays.asList("a1", "a2", "a3")
	    .stream()     // on a list of objects return a regular obj streams
	    .findFirst()
	    .ifPresent(System.out::println);  // a1

	Stream.of("a1", "a2", "a3")   // create a stream from object references
	    .findFirst()
	    .ifPresent(System.out::println); // a1

	System.out.println("------------ 3 --------------------------------- ");
	
	Stream.of("one", "two", "three", "four")
            .filter(e -> e.length() > 3)
            .peek(e -> System.out.println("Filtered value: " + e))
            .map(String::toUpperCase)
            .peek(e -> System.out.println("Mapped value: " + e))
            .collect(Collectors.toList());
	
	System.out.println("----------- 4 ----------------------------- ");

	// steams with primitive data type
	IntStream.range(1,4)
	    .forEach(System.out::println);

	Arrays.stream(new int[] {1,2,3})
	    .map(n -> 2 * n + 1)
	    .average()                       // aggregate operations
	    .ifPresent(System.out::println); // 5.0
	
	System.out.println("------------ 5 ---------------------------- ");
	
	// Transform a regular object stream to a primitive stream
	// using mapToInt(), mapToLong() and mapToDouble().
	Stream.of("a1", "a2", "a3")
	    .map(s -> s.substring(1))
	    .mapToInt(Integer::parseInt)
	    .max()
	    .ifPresent(System.out::println);   // 3

	// Transform a primitive stream into an object stream
	IntStream.range(1,4)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);    // a1 a2 a3 

	// a stream of doubles -> int stream -> an object stream of string
	Stream.of(1.0, 2.0, 3.0)
	    .mapToInt(Double::intValue)
	    .mapToObj(i -> "a" + i)
	    .forEach(System.out::println);    // a1 a2 a3

	System.out.println("------------- 6 --------------------------- ");

	// Laziness
	// intermediate operations will only be executed when
	// a terminal operation is present.
	
	Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
		    System.out.println("filter: " + s);
		    return true;
		});              // Nothing is printed

	System.out.println();

	Stream.of("d2", "a2", "b1", "b3", "c")
	    .filter(s -> {
		    System.out.println("filter: " + s);
		    return true;
		})
	    .forEach(s -> System.out.println("forEach: " + s));

	System.out.println("------------- 7 --------------------------- ");

	// Processing Order
	// public boolean anyMatch(Predicate<T> predicate)
	// anyMatch is short-circuiting terminal operations
	// public boolean startsWith(String prefix)

	Stream.of("d2", "a2", "b1", "b3", "c")
	    .map(s -> {
		    System.out.println("map: " + s);
		    return s.toUpperCase();
		})
	    .anyMatch(s -> {
		    System.out.println("anyMatch: " + s);
		    return s.startsWith("A");
		});
	
	// map: d2
	// anyMatch: D2
	// map: a2
	// anyMatch: A2      (short-circuiting)

	System.out.println("------ map-filter --------------------------- ");

	Stream.of("d2", "a2", "b1", "b3", "a4")
	    .map(s -> {
		    System.out.println("map:     " + s);
		    return s.toUpperCase();
	     })
	    .filter(s -> {
		    System.out.println("filter:  " + s);
		    return s.startsWith("A");
	     })
	    .forEach(s -> System.out.println ("forEach: " + s));

	   // map: d2 \n filter: D2  \n map: a2 \n filter A2 \n foeEach A2 \n
	   // map: b1 \n filter: B1  \n map: b3 \n filter B3 \n
	   // map: a4 \n filter: A4  \n forEach: A4 
	
        System.out.println("------ filter-map --------------------------- ");

	Stream.of("d2", "a2", "b1", "b3", "a4")
	    .filter(s -> {
	           System.out.println("filter:  " + s);
       	           return s.startsWith("a");
	     })
	    .map(s -> {
		    System.out.println("map:     " + s);
		    return s.toUpperCase();
	     })
	    .forEach(s -> System.out.println ("forEach: " + s));

	System.out.println("------ sorted-filter-map -------------------- ");

	Stream.of("d2", "a2", "b1", "b3", "c")
	    .sorted((s1,s2) -> {
		    System.out.printf("sort:    %s; %s\n", s1, s2);
		    return s1.compareTo(s2);
	     })
	    .filter(s -> {
	           System.out.println("filter:  " + s);
       	           return s.startsWith("a");
	     })
	    .map(s -> {
		    System.out.println("map:     " + s);
		    return s.toUpperCase();
	     })
	    .forEach(s -> System.out.println ("forEach: " + s));

	System.out.println("------ streamSupplier --------------------------- ");

	Supplier<Stream<String>> streamSupplier = 
	    () -> Stream.of("d2", "a2", "b1", "b3", "c")
	          .filter(s -> s.startsWith("a"));
	streamSupplier.get().anyMatch(s -> true);  // ok
	streamSupplier.get().noneMatch(s -> true); // ok

	System.out.println("------ Collect --------------------------- ");

	class Person {
	    String name;
	    int age;
	    Person(String name, int age) { this.name = name; this.age = age; }
	    @Override
	    public String toString() { return name; }
	}

	List<Person> persons =
	    Arrays.asList(
	         new Person("Max", 18),
	         new Person("Peter", 23),
	         new Person("Pamela", 23),
	         new Person("David", 12));
	
	// collect: transform the elements of the stream into a List, Set, or Map
	List<Person> filtered =
	    persons.stream()
	           .filter(p -> p.name.startsWith("P"))
	           .collect(Collectors.toList());
	           // .collect(Collectors.toSet());
	
	System.out.println(filtered);    // [Peter, Pamela]

	System.out.println("------ FlatMap for List ----------------------- ");

	// map      :: Stream T -> (T -> R) -> Stream R
	// flatMap  :: Stream T -> (T -> Stream R) -> Stream R
	//   the second argument is lifted to (Stream T -> Stream(Stream R))
	//   and then flattened to (Stream R)
	// flatMap s g = flatten (s.
	// stream   :: T -> Stream T  or   Stream T -> Stream (Stream T)
	
        class Bar {
	    String name;
	    Bar(String name) { this.name = name; }
	}
	
	class Foo {
	    String name;
	    List<Bar> bars = new ArrayList<>();
	    Foo(String name) { this.name = name; }
	}

	List<Foo> foos = new ArrayList<>();

	// Create foos
	IntStream.range(1,4)
	    .forEach(i -> foos.add(new Foo("Foo" + i)));

	// Create bars
	foos.forEach(f ->
	    IntStream.range(1, 4)
	    .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

	foos.stream()
	    .flatMap(f -> f.bars.stream())               // concat
	    .forEach(b -> System.out.println(b.name));

	System.out.println("------ Symplified Version using peek --------------- ");
	// peek perform the provided action and return the stream

	IntStream.range(1, 4)
	    .mapToObj(i -> new Foo("Foo" + i))  // Int -> Object
	    .peek(f -> IntStream.range(1,4)
		  .mapToObj(j -> new Bar("Bar" + j + " <- " + f.name))
		  .forEach(f.bars :: add))
	    .flatMap(f -> f.bars.stream())               // concat
	    .forEach(b -> System.out.println(b.name));

	System.out.println("------ FlatMap for Optional --------------- ");

        class Inner  { String foo; }
	class Nested { Inner inner; }
	class Outer  { Nested nested; }

	Outer outer = new Outer();
	Inner in    = new Inner();
	Nested nes  = new Nested();
	in.foo = "INNER";    nes.inner = in;     outer.nested = nes; 
	
	if (outer != null && outer.nested != null && outer.nested.inner != null)
	    System.out.println(outer.nested.inner.foo);

	// Utilizing Optional flatMap
	// flatMap :: Optional<T> -> (T -> Optional<R>) -> Optional<R>
	// Optional.of(new Outer())
	Optional.of(outer)
	    .flatMap(o -> Optional.ofNullable(o.nested))
	    .flatMap(n -> Optional.ofNullable(n.inner))
	    .flatMap(i -> Optional.ofNullable(i.foo))
	    .ifPresent(System.out::println);
	
	System.out.println("------ Reduce ---------------------- ");
	// reduce combines all elements of the stream into a sigle result.

	persons.stream()
	    // foldr max (head list) list
	    .reduce((p1,p2) -> p1.age > p2.age ? p1 : p2)
	    .ifPresent(System.out::println);              // Pamela

	Person result =
	    persons.stream()
	    // foldr addPair ("",0) [(Name,Age)]
	    .reduce(new Person("",0), (p1, p2) -> {
		    p1.age += p2.age;
		    p1.name += p2.name;
		    return p1;
	     });
       

	System.out.format("name=%s; age=%s", result.name, result.age);
	// name=MaxPeterPamelaDavid; age=76
	
    }
}

