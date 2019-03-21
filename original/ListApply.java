import java.util.function.*;
import java.util.Arrays;
import java.util.ArrayList;

class ListApply {
    
    BiFunction<Integer,Integer,Integer> max = (x,y) -> x>y ? x:y;
    
    static final Function<Integer,Integer> fac = x -> x==0
	? 1
	: x * ListApply.fac.apply(x-1);
    
    static final Function<ArrayList<Integer>,Integer> sum = xs -> xs.isEmpty()
	? 0
	: xs.get(0) + ListApply.sum.apply(new ArrayList<Integer>(xs.subList(1,xs.size())));    
    
    
    public static void main(String[] args) {
	ArrayList<Integer> list1 = new ArrayList<Integer>() {{add(2);add(4);add(3);add(7);add(5);}};
	ArrayList<Integer> list2 = new ArrayList<Integer>();

	list1.forEach(x -> list2.add(fac.apply(x)));  // void, no return type
	System.out.println(list2);

	Integer result = sum.apply(list2);
	System.out.println("Sum is " + result);
    }
}
