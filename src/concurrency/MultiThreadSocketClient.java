package concurrency;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadSocketClient {
	
	public static void main(String[] args){
		int numTask=10;
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=0;i<numTask;i++)
			exec.execute(createTask(i));
	}
	
	private static Runnable createTask(final int id){
		return new Runnable() {
			private Socket client=null;
			private int port=9999;
			public void run() {
				System.out.println("Task:"+id+" start");
				try {
					client=new Socket("localhost",port);
					PrintWriter pw=new PrintWriter(client.getOutputStream(),true);
					BufferedReader br = new BufferedReader(
                            new InputStreamReader(client.getInputStream()));
					Scanner scanner=new Scanner(System.in);
					while(true){
						String info=scanner.nextLine();
						pw.println(info);
	                    
	                    String msg = null;
	                    while ((msg = br.readLine()) != null)
	                        System.out.println(msg);
	                    
	                    if(info.equals("bye")) break;
					}
					pw.close();
					br.close();

				} catch (Exception e) {
					e.printStackTrace();
				}finally{
					try {
						if(client!=null){
							System.out.println("client "+id+" closed.");
							client.close();
						}
					} catch (Exception e2) {
					}
				}
				
			}
		};
	}

}
