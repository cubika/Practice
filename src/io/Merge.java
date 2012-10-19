package io;

import java.io.*;
import java.util.Arrays;

public class Merge {


	public static void append(File source,File dest){
		BufferedReader br=null;
		FileWriter fw=null;
		try {
			br=new BufferedReader(new FileReader(source));
			fw=new FileWriter(dest,true);
			
			char[] buffer=new char[4096];
			while( (br.read(buffer)) != -1){
				fw.write(buffer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)
					br.close();
				if(fw!=null)
					fw.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}

		
	}
	
	public static void main(String[] args){
		String directoryName="E:\\下载\\围棋\\定式";
		String[] catagary={"星定式","三三定式","小目定式","目外定式","高目定式"};
		
		for(String cataString:catagary){
			String fileName=cataString+".html";
			File htmlFile=new File(directoryName,fileName);
			try {
				htmlFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		File Directory=new File(directoryName);
		String[] filenameArray=Directory.list();
		
		Arrays.sort(filenameArray,String.CASE_INSENSITIVE_ORDER);

		for(int i=0;i<filenameArray.length;i++)
			System.out.println(filenameArray[i]);
		
		for(String travelName:filenameArray){
			
			for(String base:catagary){
				if(travelName.contains(base)){
					append(new File(directoryName,travelName),
							new File(directoryName,base+".html"));
				}
			}
		}
	}
}
