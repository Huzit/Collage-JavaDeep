class SelectOverload {
    static boolean k(boolean x, int y) {  return x; }
    static char k(char x, boolean y) {  return x; }
    static int k(int x, char y) {  return x; }    

    public static void main(String[] args) {
        System.out.println("k(true, 1) is " + k(true, 1));
        System.out.println("k('a', false) is " + k('a', false));
        System.out.println("k(1, 'c') is " + k(1, 'c'));
        // System.out.println("k(true, true) is " + k(true, true));
    }
}
