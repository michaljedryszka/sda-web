package pl.sda.java.jsp.klasy;

public class Main {
    public static void main(String[] args) {
        Object ref;
        ref = new A();
        ref = new B();
        ref = new C();


        B bref = new B();
        D dref = bref;
        bref.b();
        bref.d();

        dref.d();
        //dref.b();

        C cref = new C();
        ref = new C();
        dref = new C();
        bref = new C();

//        ref.c();
    }
}
