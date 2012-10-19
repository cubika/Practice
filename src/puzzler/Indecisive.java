package puzzler;

public class Indecisive {
	//无论try语句块正常结束还是异常结束，finally语句块都会执行
    public static void main(String[] args) {
        System.out.println(decision());
    }

    static boolean decision() {
        try {
            return true;
        } finally {
            return false;
        }
    } 
}
