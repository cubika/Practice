package puzzler;

public class AnimalFarm {
	
	//pig��dogָ��ͬ�Ķ������Դ�ӡ����
	//+���Ӳ�����Ҫ��==�����ȼ��ߣ��������("Animals are equal: "+pig)==dog���ж�
	//���ԣ��Բ������ʽ��Ҫ�����ţ��ڴ����и�Ӧ��ʹ��equals
    public static void main(String[] args) {
        final String pig = "length: 10";
        final String dog = "length: " + pig.length();

        System.out.println("Animals are equal: "
                           + pig == dog);
    }
    
}
