package puzzler;

public class LastLaugh {
	
	//只有当+的操作数中至少有一个是String时，才会进行字符串连接
    public static void main(String args[]) {
    	
        System.out.println("H" + "a");
        
        //+两侧都没有字符串，因此不会进行字符串重载
        //char就是一个整数，72+99=169
        System.out.println('H' + 'a');
        
        //可以使用printf
        System.out.printf("%c%c", 'H','a');
    }

}
