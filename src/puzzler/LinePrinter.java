package puzzler;

//因为注释中有LF的转义Unicode，所以从这个字符起就开始换行了，剩下的注释前面就不在有注释符了
//可以使用printf %n 来打印恰当的与平台无关的行分隔符
public class LinePrinter {

	public static void main(String[] args) {
		    // Note: \u000A //(我加的)is Unicode representation of linefeed (LF)
		    char c = 0x000A;
		    System.out.println(c);
		  }
}
