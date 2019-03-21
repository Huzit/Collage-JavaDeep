import java.util.ArrayList;
import java.util.List;

public class ForEachList {
    public static void main(String[] args) {
	List<String> items = new ArrayList<>();
	items.add("A");	items.add("B");	items.add("C");
	items.add("D");	items.add("E");

	for(String item : items)
		System.out.print(item + " " );

	//lambda
	//Output : A,B,C,D,E
	items.forEach(item -> System.out.print(item + " "));
		
	//Output : C
	items.forEach(item->{
		if("C".equals(item))
			System.out.print(item + " ");
	});
		
	//method reference
	//Output : A,B,C,D,E
	items.forEach(System.out::print);
	
	//Stream and filter
	//Output : B
	items.stream()
		.filter(s->s.contains("B"))
		.forEach(System.out::print);
    }
}
