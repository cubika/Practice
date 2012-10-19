package puzzler;

//32位表示成16进制可以表示成为8位，但是由于0xcafebabe的首位是1，因此表示为负数

public class JoyOfHex {

    public static void main(String[] args) {
        System.out.println(
            Long.toHexString(0x100000000L + 0xcafebabe));
    }
}
