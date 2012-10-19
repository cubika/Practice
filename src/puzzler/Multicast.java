package puzzler;

/*-1就是将所有32位都置一，转化为byte，只留下后面的8个一，转化为char，变为16个一，
转化为int，前面加0，还是只有16个一，所以是65535.
所以，原则就是：转化之前是有符号的，就进行符号扩展；转化之前是无符号的，就进行零扩展*/

public class Multicast {

    public static void main(String[] args) {
        System.out.println((int) (char) (byte) -1);
    }
}
