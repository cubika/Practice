package puzzler;

import java.util.Random;

//�������������bug, 1:rnd.nextInt(2)ʵ��ֻ��0,1�������
//2.switch case���Ǽ�break��
//3.StringBufferû���ַ��Ĺ���������˽��ַ���Ϊ�����֣���������һ����ô��Ļ�����
//����ʲô�������ӡ��ֻ���ӡain
public class Rhymes {
    private static Random rnd = new Random();

    public static void main(String[] args) {
        StringBuffer word = null;
        switch(rnd.nextInt(2)) {
            case 1:  word = new StringBuffer('P');
            case 2:  word = new StringBuffer('G');
            default: word = new StringBuffer('M');
        }
        word.append('a');
        word.append('i');
        word.append('n');
        System.out.println(word);
    }
}
