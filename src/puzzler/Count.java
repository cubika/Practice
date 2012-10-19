package puzzler;

public class Count {
    public static void main(String[] args) {
        final int START = 2000000000;
        int count = 0;
        //不要用float进行循环索引
        //(float)START=START+50，因为START太大了，会丢失精度
        for (float f = START; f < START + 50; f++)
            count++;
        System.out.println(count);
    }
}
