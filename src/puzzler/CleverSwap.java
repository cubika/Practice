package puzzler;

public class CleverSwap {

    public static void main(String[] args) {
        int x = 1984;
        int y = 2001;
        //������Ϊ��java�У��������Ǵ���������ֵ�ģ�x^=expr����������ȡx,�ټ���expr
        //���ԣ��ڵ����ı��ʽ��Ҫ�������ͬ�ı�����ֵ���Σ�����ҪдһЩ���Ƹ��ӵļ���
        x ^= y ^= x ^= y;
/*      ����ǿ��Խ�����
        x = x ^ y;
        y = y ^ x;
        x = y ^ x;*/
        System.out.println("x = " + x + "; y = " + y);
    }
}
