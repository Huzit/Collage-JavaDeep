import java.util.HashMap;
import java.util.Map;

public class ForEachMap {
    public static void main(String[] args) {
	Map<String, Integer> items = new HashMap<>();
	items.put("A", 10); items.put("B", 20); items.put("C", 30);
	items.put("D", 40); items.put("E", 50); items.put("F", 60);

	System.out.println("\nUsing for Iterator");
	for (Map.Entry<String, Integer> entry : items.entrySet())
	   System.out.println("Item : " + entry.getKey() +
			      " Count : " + entry.getValue());

	System.out.println("\nUsing forEach and Lambda");
	items.forEach(
	   (k,v) -> System.out.println("Item : " + k + " Count : " + v) );

	System.out.println("\nUsing forEach, Lambda and statements block");	
	items.forEach( (k,v) -> {
	    System.out.println("Item : " + k + " Count : " + v);
	    if("E".equals(k))
		System.out.println("Hello E");
	});
    }
}
