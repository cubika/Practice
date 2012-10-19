package puzzler;

import java.util.Random;

//这个程序有三个bug, 1:rnd.nextInt(2)实际只有0,1两种情况
//2.switch case忘记加break了
//3.StringBuffer没有字符的构造器，因此将字符认为是数字，即开辟了一个那么大的缓冲区
//所以什么都不会打印，只会打印ain
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
