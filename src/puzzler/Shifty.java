package puzzler;

public class Shifty {
	//���Ƶ���Ҫ��32������ģ����-1һֱû��
    public static void main(String[] args) {
        int i = 0;
        while (-1 << i != 0)
            i++;
        System.out.println(i);
    }
}
