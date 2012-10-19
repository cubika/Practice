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
	//Type1��f������Type2��f�����׳����쳣��ͬ������Type3��f�����Ƕ��ߵĽ�������ʲô�쳣��û�׳�
    public void f() {
        System.out.println("Hello world");
    }

    public static void main(String[] args) {
        Type3 t3 = new Arcane3();
        t3.f();
    }
}