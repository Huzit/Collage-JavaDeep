import java.util.ArrayList;
import java.util.Iterator;

interface I {
    void ma();
}

class A implements I {
    public void ma() {
	System.out.println("Implementing in A");
    }
}

class B implements I {
    public void ma() {
	System.out.println("Implementing in B");
    }
}

class C implements I {
    public void ma() {
	System.out.println("Implementing in C");
    }
}

class D implements I {
    public void ma() {
	System.out.println("Implementing in D");
    }
}

public class InterfaceTest {
    public static void main(String[] args) {
	// array whose elements are objects of subclasses implementing I
	ArrayList<I> arrs = new ArrayList<> ();
	arrs.add(new D());
	arrs.add(new B());
	arrs.add(new A());
	arrs.add(new C());
	for (I obj : arrs)
	    obj.ma();
    }
}
