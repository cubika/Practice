package puzzler;

public class InTheLoop {
    public static final int END = Integer.MAX_VALUE;
    public static final int START = END - 100;

    public static void main(String[] args) {
        int count = 0;
        //��i=ENDʱ��i�Ѿ��ﵽ���i�ټ�һ�ͻص���Сֵ�ˣ���˾����������ѭ��
        for (int i = START; i <= END; i++)
            count++;
        System.out.println(count);
    }
}
