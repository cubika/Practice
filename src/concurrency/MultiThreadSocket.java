package concurrency;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import java.util.concurrent.*;

public class MultiThreadSocket {

	private int port=9999;
	private final int POOL_SIZE=10;
	private ServerSocket server;
	private ExecutorService exec;
	
	public MultiThreadSocket()
	{
		try {
			server=new ServerSocket(port);
			exec=Executors.newFixedThreadPool(Runtime.
					getRuntime().availableProcessors()*POOL_SIZE);
			System.out.println("Server start...");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void service(){
		while(true){
			Socket incoming=null;
			try {
				incoming=server.accept();
				exec.execute(new Handler(incoming));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}
	
	public static void main(String[] args){
		new MultiThreadSocket().service();
	}
}


class Handler implements Runnable{
	
	private Socket socket;
	
	public Handler(Socket socket){
		this.socket=socket;
	}
	
	public void run(){
		System.out.println("New connection accepted "+
				socket.getInetAddress()+" port:"+socket.getPort());
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
			String msg=null;

			while((msg=br.readLine())!=null){
				if(msg.equals("bye"))
					break;
				System.out.println("server has received:"+msg);
				pw.println("from server:"+msg.toUpperCase());

			}
			
			br.close();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				if(socket!=null){
					System.out.println("connection closed.");
					socket.close();
				}
			} catch (Exception e2) {
			}
		}
		
	}
}