package io;

import java.io.*;
import java.nio.*;
import java.nio.channels.FileChannel;

public class CopyFile {

	static void copyTraditional(File source,File target) throws IOException{
		if(source.isFile() && source.exists()){
				FileInputStream fis=new FileInputStream(source);
				FileOutputStream fos=new FileOutputStream(target);
				byte[] buffer=new byte[1024];
				while( (fis.read(buffer)) != -1)
				{
					fos.write(buffer);
				}
				fis.close();
				fos.close();
		}
	}
	
	static void copyNew(File source,File target) throws IOException{
		if(source.isFile() && source.exists()){
				FileInputStream fis=new FileInputStream(source);
				FileOutputStream fos=new FileOutputStream(target);
				ByteBuffer buffer=ByteBuffer.allocate(1024);
				
				FileChannel fcin=fis.getChannel();
				FileChannel fout=fos.getChannel();
				
				while(true){
					buffer.clear();
					int r=fcin.read(buffer);
					if(r==-1) break;
					buffer.flip();
					fout.write(buffer);
				}
				fcin.close();
				fout.close();
				
				fis.close();
				fos.close();
		}

	}
	
	public static void main(String[] args){
		File source=new File("E:/temporary/copy/adapt.txt");
		File target1=new File("E:/temporary/copy/tradtarget.txt");
		File target2=new File("E:/temporary/copy/newtarget.txt");
		
		try{
			copyTraditional(source,target1);
			copyNew(source,target2);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
}
