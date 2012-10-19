package puzzler;

public class Change {

	//并不打印出0.90，因为float和double不适宜用精度运算
	//这是二进制和十进制之间的差异造成的
	//如果需要精度，可以使用BigDecimal
    public static void main(String args[]) {
        System.out.println(2.00 - 1.10);
    }
}
