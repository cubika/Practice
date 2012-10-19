package network;

import java.io.*;
import java.net.*;

public class GetContent {


	public static void main(String[] args) throws IOException {
		//String urlName="http://news.cnblogs.com/n/160028/";
		String urlName="http://weiqi.sports.tom.com/secondary/wskt/dingshi/spr_wq_dingshi_04.htm";
		URL url=new URL(urlName);
	        
//	        BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),"gb2312"));
//		String s=null;
//		while( (s=br.readLine()) != null){
//			System.out.println(s);
//		}
		
		byte[] bytes=new byte[1024*1000];
		InputStream is=url.openStream();
		int index=0;
		int count=is.read(bytes, index, 1024*100);
		while(count!=-1){
			index+=count;
			count=is.read(bytes, index, 1024*100);
		}
//		FileOutputStream fos=new FileOutputStream("E:\\DATA.txt");
//		fos.write(bytes, 0, index);
		String temp=new String(bytes,"gb2312");
		System.out.println(temp);
	}

}
