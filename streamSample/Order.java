// https://stackoverflow.com/questions/32656888/recursive-use-of-stream-flatmap

import java.util.*;
import java.util.stream.*;

public class Order {
    private String id;
    private List<Order> orders = new ArrayList<>();

    @Override
    public String toString() {
        return this.id;
    }

    public void setId(String id) {
	this.id = id;
    }

    public void setOrders (List<Order> orders) {
	this.orders = orders;
    }

    public String getId(String id) {
	return this.id;
    }

    public static void main(String[] args) {
	Order o1 = new Order();
        o1.setId("1");
        Order o11 = new Order();
        o11.setId("1.1");
        Order o111 = new Order();
        o111.setId("1.1.1");
        List<Order> o11Children = new ArrayList<>(Arrays.asList(o111));
        o11.setOrders(o11Children);
        
        Order o12 = new Order();
        o12.setId("1.2");
        List<Order> o1Children = new ArrayList<>(Arrays.asList(o11, o12));
        o1.setOrders(o1Children);
        
        Order o2 = new Order();
        o2.setId("2");
        Order o21 = new Order();
        o21.setId("2.1");
        Order o22 = new Order();
        o22.setId("2.2");
        Order o23 = new Order();
        o23.setId("2.3");
        List<Order> o2Children = new ArrayList<>(Arrays.asList(o21, o22, o23));
        o2.setOrders(o2Children);
        
        List<Order> orders = new ArrayList<>(Arrays.asList(o1, o2));

	System.out.println(orders);
    }

    /// Should do some more
}
