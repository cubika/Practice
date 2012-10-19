package puzzler;

/*下面这个例子中的MICROS_PER_DAY虽然声明为了long，但是是在使用int计算之后才转换为long的
因此，不可避免的造成了溢出
所以，为了防止溢出，需要先变为long，再相乘，即24L*60*60*1000*1000*/

public class LongDivision {
	
    public static void main(String[] args) {
        final long MICROS_PER_DAY = 24 * 60 * 60 * 1000 * 1000;
        final long MILLIS_PER_DAY = 24 * 60 * 60 * 1000;

        System.out.println(MICROS_PER_DAY / MILLIS_PER_DAY);
    }
}
