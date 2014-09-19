package concurrency;

public class WhoisFast implements Runnable {
	
	private static int count=0;
	
	public void run(){
		System.out.println("id : "+count++);
		while(true){
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("hello");
		}
	}
	
	public static void main(String[] args) {
		
		new Thread(new WhoisFast()).start();
		System.out.println(" Main end");
	}
}
