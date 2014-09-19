package concurrency;

import generic.Generator;

import java.util.Arrays;
import java.util.concurrent.*;


public class FibbThreads implements Generator<Integer>,Runnable{
	private  int count=0;
	private final int n;
	public FibbThreads(int n){
		this.n=n;
	}
	public Integer next(){
		return fibb(count++);
	}
	private Integer fibb(int i){
		if(i<2) return 1;
		return fibb(i-2)+fibb(i-1);
	}
	public void run(){
		Integer[] arrays=new Integer[n];
		for (int i = 0; i < arrays.length; i++) {
			arrays[i]=next();
		}
		System.out.println("seq of "+n+" : "+Arrays.toString(arrays));
	}
	
	public static void main(String[] args) {
		ExecutorService exec=Executors.newCachedThreadPool();
		for(int i=1;i<5;i++)
			exec.execute(new FibbThreads(i));
		exec.shutdown();
	}

}
