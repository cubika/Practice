package puzzler;

import java.util.regex.Pattern;

public class Me {
	
	//replaceAll�ĵ�һ��������������ʽ���������κ��ַ�
	//Ӧ��ʹ��ת�壬��Ӧ��ʹ��Pattern.quote����
	//Pattern.quote���ַ�����ȷƥ��Ϊ����
	
	public static void main(String[] args) {
		System.out.println(Me.class.getName().replaceAll(".", "/") + ".class");
		
		System.out.println(Me.class.getName().replaceAll("\\.", "/") + ".class");
		
		System.out.println(Me.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
	}
}
