package puzzler;

import java.io.File;
import java.util.regex.Matcher;

public class MeToo {
	
	//File.separator在不同平台下是不同的，在Windows平台下是反斜杠，在Unix下是正斜杠
	//在Windows平台下反斜杠造成了反义，所以错误
	//可以使用Matcher.quoteReplacement
	//也可使用replace(char,char)
	
    public static void main(String[] args) {
    System.out.println(MeToo.class.getName().
        replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + ".class");
    
    System.out.println(MeToo.class.getName().
            replace('.',File.separatorChar) + ".class");
  }
}
