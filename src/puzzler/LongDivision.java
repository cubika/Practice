package puzzler;

/*������������е�MICROS_PER_DAY��Ȼ����Ϊ��long����������ʹ��int����֮���ת��Ϊlong��
��ˣ����ɱ������������
���ԣ�Ϊ�˷�ֹ�������Ҫ�ȱ�Ϊlong������ˣ���24L*60*60*1000*1000*/

public class LongDivision {
	
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
