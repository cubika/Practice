package puzzler;

public class WorkOut {
    public static void main(String[] args) {
    	//workhard反复调用造成无限递归，本应抛出StackOverFlow溢出
    	//然而，在抛出前，会执行finally语句块，因此会执行成二叉树的情形
    	//执行时间相当长，可以认为无限循环
        workHard();
        System.out.println("It's nap time.");
    }

    private static void workHard() {
        try {
            workHard();
        } finally {
            workHard();
        }
    }
}