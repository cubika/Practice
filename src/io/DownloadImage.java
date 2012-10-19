package io;

import java.io.*;
import java.net.*;

public class DownloadImage implements Runnable{
	 
	private final String baseURL="http://weiqi.sports.tom.com/secondary/wskt/dingshi/image/sansan/";
	private String urlname=null;
	private URL downloadSiteURL;
	
	private DataInputStream dis;
	private FileOutputStream fos;
	
	public void setURL(int i){
		String nString=null;
		if(i<10 && i>0){
			nString="00"+String.valueOf(i);
		}else if(i<100 && i>=10){
			nString="0"+String.valueOf(i);
		}else{
			nString=String.valueOf(i);
		}
		
		urlname=baseURL+nString+".gif";
	}
	
	public void run(){
		if(connect()){
			download();
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
	
	private void download(){
		if(downloadSiteURL==null)
			return;
		
		String directory="E:\\œ¬‘ÿ\\Œß∆Â\\∂® Ω\\image\\sansan";
		int slashIndex=urlname.lastIndexOf("/");
		String imageName=urlname.substring(slashIndex+1);
		File imageFile=new File(directory,imageName);
		
		if(!imageFile.exists()){
			try {
				imageFile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		try {
			dis=new DataInputStream(downloadSiteURL.openStream());
			fos=new FileOutputStream(imageFile);
			
			byte[] buffer=new byte[4096];
			
			int length=-1;
			while( (length=dis.read(buffer))!=-1){
				fos.write(buffer, 0, length);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try{
				if(dis!=null)
					dis.close();
				if(fos!=null)
					fos.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		
	}
	public static void main(String[] args) {
		int start=501;
		int end=551;
		for(int i=start;i<=end;i++){
			DownloadImage dwImage=new DownloadImage();
			dwImage.setURL(i);
			
			Thread t=new Thread(dwImage);
			t.start();
		}
	}
}
