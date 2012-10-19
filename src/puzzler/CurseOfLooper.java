package puzzler;

public class CurseOfLooper {
    public static void main(String[] args) {
        // Place your declarations for i and j here
    	Integer i=new Integer(0);
    	Integer j=new Integer(0);
    	//包装类
    	//数值操作符进行值比较，判等操作符进行引用地址比较
        while (i <= j && j <= i && i != j) {
        }
    }
}
