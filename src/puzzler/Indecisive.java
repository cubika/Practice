package puzzler;

public class Indecisive {
	//����try�����������������쳣������finally���鶼��ִ��
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
