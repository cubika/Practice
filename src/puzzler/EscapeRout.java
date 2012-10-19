package puzzler;

public class EscapeRout {

	//\u0022 是双引号，所以变为"a".length()+"b".length(),所以结果是2
	//在字符串中优先使用转义字符序列，而不是Unicode字符，优先使用ASCII
	
	public static void main(String[] args) {
		// \u0022 is the Unicode escape for double-quote (")
		System.out.println("a\u0022.length() + \u0022b".length());
	}
}
