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
	 * 总结：每个类都有一个class类，类初始化分为三步：Loading，Linking和Initialization
	 * .class和classLoader仅仅完成了类的装载部分，还没有到初始化
	 * static final常量是compiled-constant，初始化之前就可以读取
	 * 当需要获取的变量是static或值还没确定的static final常量的值时，需要首先初始化
	 */
	public static void main(String[] args) {
		//由于使用.class仅仅完成了装载，但并没有实例化
		Class initiable1Class=Initiable1.class;
		//staticFinal1在编译时指定了值，所以不会引发初始化
		System.out.println(Initiable1.staticFinal1);
		//staticFinal2在编译时没有指定值，所以引发初始化
		System.out.println(Initiable1.staticFinal2);
		
		//仅仅是static变量，必须执行初始化
		System.out.println(Initiable2.staticNonFinal);
		
		try{
			Class.forName("typeInfo.Initiable3");
		}catch(Exception e){
			System.out.println("instance initiable3 error");
		}

	}

}
