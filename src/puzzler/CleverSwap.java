package puzzler;

public class CleverSwap {

    public static void main(String[] args) {
        int x = 1984;
        int y = 2001;
        //错误，因为在java中，操作数是从左向右求值的，x^=expr，则是先提取x,再计算expr
        //所以，在单个的表达式中要避免对相同的变量赋值两次，更不要写一些看似复杂的技巧
        x ^= y ^= x ^= y;
/*      这个是可以交换的
        x = x ^ y;
        y = y ^ x;
        x = y ^ x;*/
        System.out.println("x = " + x + "; y = " + y);
    }
}
