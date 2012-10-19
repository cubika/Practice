package puzzler;

public class GhostOfLooper {
    public static void main(String[] args) {
        // Place your declaration for i here
    	short i=-1;
    	//无符号右移首先将i拓宽为32位，向右移一位之后变为0x7fffffff,
    	//又由于java进行了窄化，将前16位削掉，又变成了-1
        while (i != 0)
            i >>>= 1;
    }
}
