package puzzler;

public class BigDelight {

	//Byte的范围是-127~128，而0x90是+144，所以永远不可能相等
	//两个不同类型的数字进行比较时一定要注意了
    public static void main(String[] args) {
        for (byte b = Byte.MIN_VALUE; b < Byte.MAX_VALUE; b++) {
            if (b == 0x90)
                System.out.print("Joy!");
        }
    }
    
}
