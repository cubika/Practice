package puzzler;

import java.io.UnsupportedEncodingException;

public class StringChess {
	
    public static void main(String args[]) {
        byte bytes[] = new byte[256];    
        for(int i = 0; i < 256; i++)
            bytes[i] = (byte)i;
        
    	//byte序列转换为String时使用平台默认的字符集，因此很有可能打印的不正确
        String str1 = new String(bytes);
        for(int i = 0, n = str1.length(); i < n; i++)
            System.out.print((int)str1.charAt(i) + " ");
        
        System.out.println();
        
        //可以指定字符集
        String str;
		try {
			str = new String(bytes,"ISO-8859-1");
	        for(int i = 0, n = str.length(); i < n; i++)
	            System.out.print((int)str.charAt(i) + " ");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

    }
}
