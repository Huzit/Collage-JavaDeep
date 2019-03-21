public class SideEffect {
    static int k = 0;

    static int f (int x) {             // using side-effect
	k = k + 1;
	return x + k;
    }

    static int f2(int x, int k) {     // pure functions
	return x + k;
    }

    public static void main(String[] args) {
        System.out.println("f(3) is " + f(3));
	System.out.println("f(3) is " + f(3));

	System.out.println("f2(3,4) is " + f2(3, 4));
	System.out.println("f2(3,4) is " + f2(3, 4));   
    }
}
