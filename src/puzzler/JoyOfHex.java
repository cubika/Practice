package puzzler;

//32λ��ʾ��16���ƿ��Ա�ʾ��Ϊ8λ����������0xcafebabe����λ��1����˱�ʾΪ����

public class JoyOfHex {

    public static void main(String[] args) {
        System.out.println(
            Long.toHexString(0x100000000L + 0xcafebabe));
    }
}
