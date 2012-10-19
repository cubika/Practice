package io;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class DingShiDownload implements Runnable{

	private final String baseUrl=
			"http://weiqi.sports.tom.com/secondary/wskt/dingshi/spr_wq_dingshi_";
	
	private String urlname=null;
	private URL downloadSiteURL;
	
	private BufferedReader br;
	private PrintWriter pw;
	
	private String saveFileName=null;
	private String threadInfo=null;
	
	
	public void setUrl(int number){
		String numInURL= (number<10) ? ("0"+String.valueOf(number)) :
			String.valueOf(number);
		urlname=baseUrl+numInURL+".htm";
	}
	
	public void setSaveFile(String filename){
		saveFileName=filename;
	}
	
	public void run(){
		if(connect()){
			System.out.println(Thread.currentThread().getName()+" connect success!");
			downloadBody();
			
		}
	}
	
	private boolean connect(){
		if(urlname==null)
			return false;
		try {

			downloadSiteURL=new URL(urlname);
			System.out.println(urlname);
			return true;
		} catch (MalformedURLException e) {
			System.out.println("url name error!");
		}
		return false;
	}
	
	
	private void downloadBody(){
		if(downloadSiteURL==null)
			return;
		
		File saveFile=new File(saveFileName);
		if(saveFile.length()>0)
			return;
		
		threadInfo=Thread.currentThread().getName();
		
		StringBuffer sb = new StringBuffer();
		boolean finish=false;
		char[] buffer=new char[4096];
		
		int startTableIndex=-1,endTableIndex=-1;
		int startTableCount=0,endTableCount=0;
		
		try {	
			InputStreamReader isr=new InputStreamReader(downloadSiteURL.openStream(),"gb2312");
			br=new BufferedReader(isr);
			System.out.println(threadInfo+" get ready to retrive!");
			while( (br.read(buffer))!=-1 && !finish ){
				
				startTableIndex=-1;
				endTableIndex=-1;
				
				String temp=String.valueOf(buffer);
				
				//find table element's begin and end index
				if(temp.contains("<table")){
					startTableIndex=temp.indexOf("<table");
					startTableCount++;
				}
				if(temp.contains("</table>")){
					endTableIndex=temp.lastIndexOf("</table>");
					endTableCount++;
					if(endTableCount==startTableCount)
						finish=true;
				}
				
				
				//append to stringbuffer
				if(startTableIndex!=-1 || endTableIndex!=-1){
					if(startTableIndex==-1){
						sb.append(temp.substring(0,endTableIndex)+"</table>");
					}else if(endTableIndex==-1){
						sb.append(temp.substring(startTableIndex));
					}else{					
						sb.append(temp.substring(startTableIndex,endTableIndex)+"</table>");
					}
					
					
				}
			}
			
			System.out.println(threadInfo+" read Complete!");
			
			//write to file
			pw=new PrintWriter(saveFile);
			pw.write(sb.toString());
			System.out.println(threadInfo+" write to: "+saveFileName+" complete!");
		} catch (IOException e) {
			System.out.println("get input stream or open file error!");
		}finally{
			try {
				if(br!=null)
					br.close();
				if(pw!=null)
					pw.close();
			} catch (IOException e) {
				System.out.println("BufferedReader  close error!");
			}			
			
		}
		
	}
	
	public static void main(String[] args){
		String path="E:\\下载\\围棋\\定式";
		String[] array={"星定式","三三定式","小目定式","目外定式","高目定式"};
		
		File directory=new File(path);
		if(!directory.exists())
			directory.mkdir();
		
		int startArray[]={4,42,45,83,97,101};
		int index=0;
		
		for(String catagary : array){
			
			int startNumber=startArray[index];
			int endNumber=startArray[index+1];
			index++;
			for(int i=startNumber;i<endNumber;i++){
				String num=(i<10)?("0"+String.valueOf(i)):(String.valueOf(i));
				String fileName=path+File.separator+catagary+"_"+num+".txt";
				File file=new File(fileName);
				if(!file.exists())
					try {
						file.createNewFile();
					} catch (IOException e) {
						System.out.println("create file "+fileName+" error!");
					}
				
				
				DingShiDownload dwload=new DingShiDownload();
				dwload.setUrl(i);
				dwload.setSaveFile(fileName);
				Thread t=new Thread(dwload);
				t.start();
			}
			
		}
	}
}
