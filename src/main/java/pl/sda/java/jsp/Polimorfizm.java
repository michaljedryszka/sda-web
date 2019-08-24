package pl.sda.java.jsp;

public class Polimorfizm {

    public static void main(String[] args) {
        A a = new A();
        A b = new B();
        //b.x??
        //b.getx??
        System.out.println(a.x);
        System.out.println(b.x);
    }
}

class A {

    int x = 1;

    int getx() {
        return 1;
    }

    int getX() {
        return this.x;
    }

    void a() {
    }
}

class B extends A {

    int x = 2;

    B() {
        x = 2;
    }

    @Override
    int getx() throws RuntimeException {
        return 2;
    }
}
