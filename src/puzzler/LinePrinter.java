package puzzler;

//��Ϊע������LF��ת��Unicode�����Դ�����ַ���Ϳ�ʼ�����ˣ�ʣ�µ�ע��ǰ��Ͳ�����ע�ͷ���
//����ʹ��printf %n ����ӡǡ������ƽ̨�޹ص��зָ���
public class LinePrinter {

	public static void main(String[] args) {
		    // Note: \u000A //(�Ҽӵ�)is Unicode representation of linefeed (LF)
		    char c = 0x000A;
		    System.out.println(c);
		  }
}
