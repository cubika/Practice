package generic;

import java.util.Iterator;
import java.util.Random;

public class CoffeeGenerator implements Generator<Coffee>,Iterable<Coffee>{

	Class[] types={Americano.class,Breve.class,
			Cappuccino.class,Latte.class,Mocha.class};
	//new Random(long seed)
	Random  random=new Random(47);
	private int size=0;
	
	public CoffeeGenerator() {
	}
	public CoffeeGenerator(int sz){
		size=sz;
	}
	
	public Coffee next(){
		try {
			return (Coffee)
					types[random.nextInt(types.length)].newInstance();
		}catch(Exception e){
			throw new RuntimeException(e);
		}
	}
	
	class CoffeeIterator implements Iterator<Coffee>{
		private int count=size;
		public boolean hasNext() {
			return count>0;
		}

		public Coffee next() {
			count--;
			return CoffeeGenerator.this.next();
		}

		public void remove() {
			throw new UnsupportedOperationException();
			
		}
		
	}
	
	public Iterator<Coffee> iterator(){
		return new CoffeeIterator();
	}

	public static void main(String[] args) {
		CoffeeGenerator gen=new CoffeeGenerator();
		for(int i=0;i<5;i++)
			System.out.println(gen.next());
		
		//这一点比较难懂，因为CoffeeGenerator实现了Iterable接口，所以可以实现foreach，
		//不断的next直到count=0
		for(Coffee c:new CoffeeGenerator(4))
			System.out.println(c);
	}



}
