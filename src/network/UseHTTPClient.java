package network;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public class UseHTTPClient {
	 
	public static void main(String[] args) throws ClientProtocolException, IOException{
		HttpClient httpclient=new DefaultHttpClient();
		HttpGet httpget = new HttpGet("http://www.google.com");
		HttpResponse response = httpclient.execute(httpget);
		HttpEntity entity = response.getEntity();
		String content=EntityUtils.toString(entity,"gb2312");

		System.out.println(content);  

	}
}

