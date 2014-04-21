package io;

import java.io.*;

public class Translate {

	public static void main(String[] args) {
		String srcFilePath = "E:/BufferFolder/java/三国utf.txt";
		String destFilePath = "E:/BufferFolder/java/三国utf.txt";
		try {
			FileInputStream fis=new FileInputStream(srcFilePath);
		       byte[] head = new byte[3];  
		        fis.read(head);   
		        String code = "gb2312";  
		   
		        if (head[0] == -1 && head[1] == -2 )  
		            code = "UTF-16";  
		        if (head[0] == -2 && head[1] == -1 )  
		            code = "Unicode";  
		        if(head[0]==-17 && head[1]==-69 && head[2] ==-65)  
		            code = "UTF-8";  
		        
		        
		        System.out.println(head[0]+" "+head[1]+" "+head[2]); 
		        System.out.println(code); 
		        fis.close();
		        
//			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(srcFilePath),code));
//			OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream(
//	                destFilePath), "UTF-8");
//			
//			char[] buff=new char[4096];
//			while((br.read(buff)) != -1 ){
//				osw.write(buff);
//			}
//			br.close();
//			osw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

	    
	}
	
	public String getCharset(String filePath) throws IOException{
		FileInputStream fis=new FileInputStream(filePath);
		String charset=null;
		String[] encodings={"UTF-8","UTF-16","Unicode","gb2312"};
		for(String code : encodings){
		}
		return charset;
	}

}
