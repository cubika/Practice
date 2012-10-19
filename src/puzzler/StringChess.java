package puzzler;

import java.io.UnsupportedEncodingException;

public class StringChess {
	
    public static void main(String args[]) {
        byte bytes[] = new byte[256];    
        for(int i = 0; i < 256; i++)
            bytes[i] = (byte)i;
        
    	//byte����ת��ΪStringʱʹ��ƽ̨Ĭ�ϵ��ַ�������˺��п��ܴ�ӡ�Ĳ���ȷ
        String str1 = new String(bytes);
        for(int i = 0, n = str1.length(); i < n; i++)
            System.out.print((int)str1.charAt(i) + " ");
        
        System.out.println();
        
        //����ָ���ַ���
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
