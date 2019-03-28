import java.util.function.*;

public class FacRec {

    static final Function<Integer,Integer> factorial = x -> x == 0
	? 1
	: x * FacRec.factorial.apply(x-1);

    final UnaryOperator<Integer> factorial2 = x -> x == 0 // instance function
	? 1
	: x * this.factorial2.apply(x-1);
    
    public static void main(String[] args) {
	System.out.println("FacRec.factorial.apply(4) : " + FacRec.factorial.apply(4));

	FacRec a = new FacRec();
	a.f();
    }

    void f() { // instance method
	// instance functions are called within instance functions
	System.out.println("factorial2.apply(4) : " + factorial2.apply(4));   
    }
}
