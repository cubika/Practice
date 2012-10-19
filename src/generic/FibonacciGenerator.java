package generic;

public class FibonacciGenerator implements Generator<Integer>{

	private int count=0;
	
	public Integer next(){
		return fibb(count++);
	}
	private Integer fibb(int i){
		if(i<2) return 1;
		return fibb(i-2)+fibb(i-1);
	}
	public static void main(String[] args) {
		FibonacciGenerator gen=new FibonacciGenerator();
		for(int i=0;i<18;i++)
			System.out.println(gen.next()+" ");
	}

}
