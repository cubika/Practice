package puzzler;

public class WorkOut {
    public static void main(String[] args) {
    	//workhard��������������޵ݹ飬��Ӧ�׳�StackOverFlow���
    	//Ȼ�������׳�ǰ����ִ��finally���飬��˻�ִ�гɶ�����������
    	//ִ��ʱ���൱����������Ϊ����ѭ��
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