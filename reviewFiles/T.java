class M {
    static int s;
    int a;
    public M() {
	s = 2;
	a = 5;
    }
    
    public int r() {
	s = s + 2;
	a = this.a + 1;
	return s + this.a;
    }
}

public class T {
    public static void main (String argv[]) {
        M m = new M();
	M n = new M();
	M.s = 4;
        System.out.println(m.r()+" "+m.s+" "+M.s+" "+n.r()+" "+n.s+" "+M.s);
        m = n;
        System.out.println(m.r()+" "+m.s+" "+M.s+" "+n.r()+" "+n.s+" "+M.s);
    }
}
