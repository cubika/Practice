package puzzler;

public class Abc {
	
	//System.out.println�������ַ�������������������ܴ�ӡ���ַ�����
	//��+ȴû�������ַ�������������ˣ��Ὣ�ַ�����ת��Ϊ�ַ����ٽ�������
	//�ַ������toString�������Ǵ�ӡ ��@hashcode
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = { '1', '2', '3' };
        System.out.println(letters + " easy as " + numbers);
        
        //���Ե���String.valueOf����
        System.out.println(letters+" easy as "+String.valueOf(numbers));
    }
}
