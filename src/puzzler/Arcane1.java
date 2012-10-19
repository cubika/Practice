package puzzler;

public class Arcane1 {
	//catch语句捕获的异常一定是try语句可以抛出的，
	//所以，如果在try语句中只打印一句话，catch是不能捕获IOException异常的
    public static void main(String[] args) {
        try {
            System.out.println("Hello world");
        }finally{
        	
        }
//        } catch(IOException e) {
//            System.out.println("I've never seen println fail!");
//        }
    }
}
