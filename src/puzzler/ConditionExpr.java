package puzzler;

//�κλ�����͵ļ��㶼���������
public class ConditionExpr {

    public static void main(String[] args) {
        char x = 'X';
        int i = 0;
        //0��int�͵ĳ��������Ա�ʾΪchar����ڶ��������͵�������������char
        System.out.print(true  ? x : 0);
        //�ڶ��������͵���������һ����int��һ����char��������Ҫ��charת��Ϊint
        System.out.print(false ? i : x); 
    }
}
