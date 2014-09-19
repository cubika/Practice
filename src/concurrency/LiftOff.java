package concurrency;

public class LiftOff implements Runnable {

	//taskCount�ǹ��е�
	private static int taskCount=0;
	//id�ǲ��ɱ��
	private final int id=taskCount++;
	//countDownΪ����ʱ����run�����ﲻ�ϼ�һ
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
			//����ϵͳ����߳���ʱ����ˣ�����ȥ���������߳���
			Thread.yield();
		}

	}
}
