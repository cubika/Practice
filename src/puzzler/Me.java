package puzzler;

import java.util.regex.Pattern;

public class Me {
	
	//replaceAll的第一个参数是正则表达式，句点代笔任何字符
	//应该使用转义，更应该使用Pattern.quote方法
	//Pattern.quote将字符串精确匹配为正则
	
	public static void main(String[] args) {
		System.out.println(Me.class.getName().replaceAll(".", "/") + ".class");
		
		System.out.println(Me.class.getName().replaceAll("\\.", "/") + ".class");
		
		System.out.println(Me.class.getName().replaceAll(Pattern.quote("."), "/") + ".class");
	}
}
