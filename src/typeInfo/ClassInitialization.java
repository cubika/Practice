package typeInfo;

import java.util.Random;

class Initiable1{
	static final int staticFinal1=99999;
	static final int staticFinal2=new Random().nextInt(100);
	static{
		System.out.println("Initializating Initiable1...");
	}
}

class Initiable2{
	static int staticNonFinal=222222;
	static{
		System.out.println("Initializating Initiable2...");
	}
}

class Initiable3{
	static int staticNonFinal=333333;
	static{
		System.out.println("Initializating Initiable3...");
	}
}

public class ClassInitialization {

	/*
	 * �ܽ᣺ÿ���඼��һ��class�࣬���ʼ����Ϊ������Loading��Linking��Initialization
	 * .class��classLoader������������װ�ز��֣���û�е���ʼ��
	 * static final������compiled-constant����ʼ��֮ǰ�Ϳ��Զ�ȡ
	 * ����Ҫ��ȡ�ı�����static��ֵ��ûȷ����static final������ֵʱ����Ҫ���ȳ�ʼ��
	 */
	public static void main(String[] args) {
		//����ʹ��.class���������װ�أ�����û��ʵ����
		Class initiable1Class=Initiable1.class;
		//staticFinal1�ڱ���ʱָ����ֵ�����Բ���������ʼ��
		System.out.println(Initiable1.staticFinal1);
		//staticFinal2�ڱ���ʱû��ָ��ֵ������������ʼ��
		System.out.println(Initiable1.staticFinal2);
		
		//������static����������ִ�г�ʼ��
		System.out.println(Initiable2.staticNonFinal);
		
		try{
			Class.forName("typeInfo.Initiable3");
		}catch(Exception e){
			System.out.println("instance initiable3 error");
		}

	}

}
