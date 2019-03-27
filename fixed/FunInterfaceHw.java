@FunctionalInterface
interface Square<T,R> {
	int calculate(T t);
}

@FunctionalInterface
interface isA<T>{
	void compare(T t);
}
class FunInterfaceHw{
	public static void main(String args[]){
		int a=5;
		char b = 'B';
		Square<Integer,Integer> s = x -> x*x+a;
		int ans = s.calculate(a);
		System.out.println(ans);

		isA<Character> i = y -> {
		if(y=='A') System.out.println("true");
		if(y=='B') System.out.println("false");
		};

		i.compare(b);
	
	}
}