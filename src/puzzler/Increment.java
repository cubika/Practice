package puzzler;

public class Increment {

	//不要在单个的表达式中对相同的变量赋两次值
    public static void main(String[] args) {
        int j = 0;
        for (int i = 0; i < 100; i++)
            j = j++;
        System.out.println(j);
    }
}
