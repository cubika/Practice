package puzzler;

interface Type1 {
    void f() throws CloneNotSupportedException;
}

interface Type2 {
    void f() throws InterruptedException;
}

interface Type3 extends Type1, Type2 {
}

public class Arcane3 implements Type3 {
	//Type1的f方法和Type2的f方法抛出的异常不同，导致Type3的f方法是二者的交集，即什么异常都没抛出
    public void f() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        Type3 t3 = new Arcane3();
        t3.f();
    }
}