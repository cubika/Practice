package concurrency;

public class ForceRun implements Runnable{

	public void run(){
		
		System.out.println(Thread.currentThread().getName());
		
	}
	
	public static void main(String[] args) {
		
		ForceRun fr=new ForceRun();
		Thread t = new Thread(fr);
		
		t.start();

		for(int i=0;i<20;i++){
			if(i%7==6){
				try {
					t.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("main Ïß³Ì£º"+i);
		}
	}
}
