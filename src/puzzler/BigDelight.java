package puzzler;

public class BigDelight {

	//Byte�ķ�Χ��-127~128����0x90��+144��������Զ���������
	//������ͬ���͵����ֽ��бȽ�ʱһ��Ҫע����
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90)
                System.out.print("Joy!");
        }
    }
    
}
