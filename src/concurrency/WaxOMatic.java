package concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// basic task coperation

class Car {
	private boolean waxOn = false;
	
	public synchronized void waxed() {
		waxOn = true;
		notifyAll();
	}
	
	public synchronized void buffered() {
		waxOn = false;
		notifyAll();
	}
	
	public synchronized void waitForWaxing() throws InterruptedException {
		while(waxOn == false) {
			wait();
		}
	}
	
	public synchronized void waitForBuffering() throws InterruptedException {
		while(waxOn == true) {
			wait();
		}
	}
}

class WaxOn implements Runnable {
	
	private Car car;
	public WaxOn(Car c) {
		car = c;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				System.out.println("WaxOn!"); //开始做第一个工作
				TimeUnit.MILLISECONDS.sleep(200);
				car.waxed(); //第一个工作做完
				car.waitForBuffering(); //等待第二个工作做完
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt!");
		}
		System.out.println("End wax on task!");
	}
	
}

class WaxOff implements Runnable {
	
	private Car car;
	
	public WaxOff(Car c) {
		car = c;
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				car.waitForWaxing(); //等待第一个工作做完
				System.out.println("Wax Off!"); //开始做第二个工作
				TimeUnit.MILLISECONDS.sleep(200);
				car.buffered(); //第二个工作做完
			}
		} catch (InterruptedException e) {
			System.out.println("Exiting via interrupt!");
		}
		System.out.println("End wax off task!");
	}
	
}


public class WaxOMatic {

	public static void main(String[] args) throws InterruptedException {
		Car car = new Car();
		ExecutorService exec = Executors.newCachedThreadPool();
		exec.execute(new WaxOn(car));
		exec.execute(new WaxOff(car));
		TimeUnit.SECONDS.sleep(5);
		exec.shutdownNow();
	}

}
