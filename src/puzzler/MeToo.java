package puzzler;

import java.io.File;
import java.util.regex.Matcher;

public class MeToo {
	
	//File.separator�ڲ�ͬƽ̨���ǲ�ͬ�ģ���Windowsƽ̨���Ƿ�б�ܣ���Unix������б��
	//��Windowsƽ̨�·�б������˷��壬���Դ���
	//����ʹ��Matcher.quoteReplacement
	//Ҳ��ʹ��replace(char,char)
	
    public static void main(String[] args) {
    System.out.println(MeToo.class.getName().
        replaceAll("\\.", Matcher.quoteReplacement(File.separator)) + ".class");
    
    System.out.println(MeToo.class.getName().
            replace('.',File.separatorChar) + ".class");
  }
}
