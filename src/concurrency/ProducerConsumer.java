package concurrency;
/*
 * 生产者消费�?模型
 * 涉及对象�?生产者，消费者，仓库，产�?
 * 1) 生产者仅仅在仓库未满时生产，仓库满则停止生产
 * 2) 消费者仅仅在仓库没有产品时才能消费，仓库空则等待
 * 3) 当消费�?发现仓库没有产品时会通知生产者生�?
 * 4) 生产者在生产处可消费产品的时候，应�?知等待的消费者去消费
 */

// 仓库
class Depot {
	private int capacity; // 仓库容量
	private int size; // 实际数量

	public Depot(int capacity) {
		this.capacity = capacity;
		this.size = 0;
	}

	public synchronized void produce(int val) {
		try {
			// 想要生产的数�?
			int left = val;
			// 生产过程可能分为几轮，直到满足目标数量为�?
			while(left > 0) {
				// 仓库已满，需要等待消费�?进行消费
				while(size >= capacity) {
					wait();
				}
				// 获取库存中新增的数量
				int inc = (size + left) > capacity ? (capacity - size) : left;
				size += inc;
				left -= inc;
				System.out.printf("%s produce (%3d) --> left = %3d, inc = %3d, size = %3d\n", 
					Thread.currentThread().getName(), val, left, inc, size);
				// �?��生产原子操作执行完毕，�?知消费�?进行消费
				notifyAll();
			}
		}catch(InterruptedException e) {
		
		}
	}

	public synchronized void consume(int val) {
		try {
			// 要消费的�?
			int left = val;
			while( left > 0 ) {
				// 仓库为空，等待生产�?进行生产
				while (size <= 0) {
					wait();
				}
				int dec = (size < left) ? size : left;
				size -= dec;
				left -= dec;
				System.out.printf("%s consume(%3d) <-- left=%3d, dec=%3d, size=%3d\n", 
					Thread.currentThread().getName(), val, left, dec, size);
				notifyAll();
			}
		}catch( InterruptedException e ) {

		}
	}
}

class Producer {
	private Depot depot;
	public Producer(Depot depot) {
		this.depot = depot;
	}

	public void produce(final int val) {
		new Thread() {
			public void run() {
				depot.produce(val);
			}
		}.start();
	}
}

class Consumer {
	private Depot depot;
	public Consumer(Depot depot) {
		this.depot = depot;
	}

	public void consume(final int val) {
		new Thread() {
			public void run() {
				depot.consume(val);
			}
		}.start();
	}
}

public class ProducerConsumer {
	public static void main(String[] args) {
		Depot mDepot = new Depot(100);
		Producer mPro = new Producer(mDepot);
		Consumer mCon = new Consumer(mDepot);

		mPro.produce(60);
		mPro.produce(120);
		mCon.consume(90);
		mCon.consume(150);
		mPro.produce(110);
	}
}