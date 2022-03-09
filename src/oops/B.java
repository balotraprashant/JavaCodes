package oops;

class A {
    // public A(String s){
    public A() {
        System.out.println("A");
    }
}

public class B extends A {
    public B(String s) {
//        super(s);
        System.out.println("B");
    }

    public static void main(String[] args) {
        new B("C");
        System.out.println("D");
    }
}
