package puzzler;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
    	short i=-1;
    	//�޷����������Ƚ�i�ؿ�Ϊ32λ��������һλ֮���Ϊ0x7fffffff,
    	//������java������խ������ǰ16λ�������ֱ����-1
        while (i != 0)
            i >>>= 1;
    }
}
