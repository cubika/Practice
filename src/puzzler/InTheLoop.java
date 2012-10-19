package puzzler;

public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
        //当i=END时，i已经达到最大，i再加一就回到最小值了，因此就造成了无限循环
        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }
}
