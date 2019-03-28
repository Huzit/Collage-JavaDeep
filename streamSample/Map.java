import java.util.function.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Map {

    static final BiFunction<ArrayList<Integer>,Function<Integer,Integer>,ArrayList<Integer>> map = (l,f) ->
    { if (l.isEmpty()==true)  new ArrayList<Integer>() ; 
	else {
	    ArrayList<Integer> x = new ArrayList<Integer> (f.apply(l.get(0)));
	    ArrayList<Integer> xs = new ArrayList<Integer> (l.subList(1,l.size()));
	    return x.add(Map.map.apply(xs, f)); } };
	
	// : {f.apply(l.get(0)).((new ArrayList<Integer>()).add(this.map.apply(new ArrayList<Integer>(l.subList(1,l.size())), f)));}
       
	UnaryOperator<Integer> factorial2 = x -> x == 0 // instance function
	? 1
	: x * this.factorial2.apply(x-1);
    
    public static void main(String[] args) {
	//	System.out.println("Map.factorial.apply(4) : " + Map.factorial.apply(4));

	Map a = new Map();
	a.f();
    }

    void f() { // instance method
	// instance functions are called within instance functions
	System.out.println("factorial2.apply(4) : " + factorial2.apply(4));   
    }
}
