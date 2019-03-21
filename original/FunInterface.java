/* 
 A functional interface is an interface that contains only one abstract method.
 Lambda can be used to represent the instance of a functional interface.
 A functional interface can have any number of default methods.
 Runnambe, ActionListener, Comparable, and etc.
 Before Java 8, we had to create anonymous inner class objects or implement these interface.

  @FunctionalInterface annonation is ued to ensure that the functional interface can't have more than one abstract method. It is not mandatory.
*/

@FunctionalInterface
interface Square {
    int calculate(int x);
}
 
class FunInterface {
    public static void main(String args[]) {
        int a = 5;
 
        // lambda expression to define the calculate method
        Square s = x -> x*x + a;   // a must be final
 
        // parameter passed and return type must be
        // same as defined in the prototype
        int ans = s.calculate(a);
        System.out.println(ans);
	// a = a + 2;         // error: a must be final or effectively final
	// System.out.println(s.calculate(3));
    }
}

