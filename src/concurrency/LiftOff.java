package concurrency;

public class LiftOff implements Runnable {

	//taskCount是公有的
	private static int taskCount=0;
	//id是不可变的
	private final int id=taskCount++;
	//countDown为倒计时，在run方法里不断减一
	protected int countDown=10;
	public LiftOff(){
		
	}
	public LiftOff(int countDown){
		this.countDown=countDown;
	}
	public String status(){
		return "#"+id+"("+(countDown>0?countDown+"),":"liftOff!);");
	}
	public void run(){
		while(countDown-- > 0){
			System.out.print(status());
			//告诉系统这个线程暂时完成了，可以去处理其他线程了
			Thread.yield();
		}

	}
}
