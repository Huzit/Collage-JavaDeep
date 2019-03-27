@FunctionalInterface
interface Square<T,R> {
	int calculate(T t);
}

@FunctionalInterface
interface isA<T>{
	boolean compare(T t);
}
class FunInterfaceHw{
	public static void main(String args[]){
		int a=5;
		char b = 'A';
		Square<Integer,Integer> s = x -> x*x+a;
		int ans = s.calculate(a);
		System.out.println(ans);
		
		isA<Character> i = y -> ((y=='A') ? true : false) ;
		boolean com = i.compare(b);
		System.out.println( com );
	}
}