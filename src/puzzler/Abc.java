package puzzler;

public class Abc {
	
	//System.out.println重载了字符数组参数的情况，因此能打印出字符序列
	//而+却没有连接字符数组的情况，因此，会将字符数组转化为字符串再进行连接
	//字符数组的toString方法就是打印 类@hashcode
    public static void main(String[] args) {
        String letters = "ABC";
        char[] numbers = { '1', '2', '3' };
        System.out.println(letters + " easy as " + numbers);
        
        //可以调用String.valueOf方法
        System.out.println(letters+" easy as "+String.valueOf(numbers));
    }
}
