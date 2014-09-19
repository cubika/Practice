package concurrency;

import java.util.concurrent.*;

public class CachedThreadPool {

	public static void main(String[] args) {
	
		ExecutorService service=Executors.newCachedThreadPool();
		for(int i=0;i<5;i++){
			service.execute(new LiftOff());
		}
		service.shutdown();
	}

}
