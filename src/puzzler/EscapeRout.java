package puzzler;

public class EscapeRout {

	//\u0022 ��˫���ţ����Ա�Ϊ"a".length()+"b".length(),���Խ����2
	//���ַ���������ʹ��ת���ַ����У�������Unicode�ַ�������ʹ��ASCII
	
	public static void main(String[] args) {
		// \u0022 is the Unicode escape for double-quote (")
		System.out.println("a\u0022.length() + \u0022b".length());
	}
}
