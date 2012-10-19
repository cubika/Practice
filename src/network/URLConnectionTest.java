package network;

import java.io.IOException;
import java.net.*;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class URLConnectionTest {

	public static String base64Encode(String input){

		return "";
	}
	
	public static void main(String[] args) throws IOException{
		
		String urlName;
		if(args.length>0)
			urlName=args[0];
		else 
			urlName="java.sun.com";
		
		URL url=new URL(urlName);
		URLConnection urlConnection=url.openConnection();
		
		if(args.length>2){
			String username=args[1];
			String password=args[2];
			String input=username+":"+password;
			String encoding=base64Encode(input);
			urlConnection.setRequestProperty("Authorization", "Basic"+encoding);
		}
		
		urlConnection.connect();
		
		Map<String, List<String> > headers=urlConnection.getHeaderFields();
		for(Map.Entry<String, List<String> > entry:headers.entrySet()){
			String key=entry.getKey();
			for(String value:entry.getValue())
				System.out.println(key+":"+value);
		}
		
		System.out.println("----------");
		System.out.println("getContentType: " + urlConnection.getContentType());
		System.out.println("getContentLength: " + urlConnection.getContentLength());
		System.out.println("getContentEncoding: " + urlConnection.getContentEncoding());
		System.out.println("getDate: " + urlConnection.getDate());
		System.out.println("getExpiration: " + urlConnection.getExpiration());
		System.out.println("getLastModifed: " + urlConnection.getLastModified());
		System.out.println("----------");

		
		Scanner in = new Scanner(urlConnection.getInputStream());
		while(in.hasNextLine()){
			System.out.println(in.nextLine());
			if(in.hasNextLine()) 
				System.out.println(".......");
		}
	}
}
