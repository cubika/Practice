package io;

import java.io.*;

public class Copy {

	private static char[] buff=new char[1024];
	public static void copy(File source,File target) throws IOException{
		//File targetFile=new File(target.getAbsolutePath()+"/"+source.getName());
		File targetFile=new File(target,source.getName());
		if(source.isFile()){
			BufferedReader br=new BufferedReader(new FileReader(source));
			PrintWriter pw=new PrintWriter(targetFile);
			while( (br.read(buff)) != -1){
				pw.write(buff);
			}
			br.close();
			pw.close();
		}else if (source.isDirectory()) {
			targetFile.mkdir();
			for(File file:source.listFiles()){
				copy(file, targetFile);
			}
		}
	
	}
	
	public static void main(String[] args){
		try {
			copy(new File("E:/temporary/Cache"),new File("E:/temporary/NewCopy"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
		
}
