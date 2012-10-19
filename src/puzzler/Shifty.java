package puzzler;

public class Shifty {
	//左移的数要对32进行求模，即-1一直没变
    public static void main(String[] args) {
        int i = 0;
        while (-1 << i != 0)
            i++;
        System.out.println(i);
    }
}
