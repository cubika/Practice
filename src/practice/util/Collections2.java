package practice.util;

import java.util.Collection;
import java.util.Map;

public class Collections2 {
	//分别为容器Collection和容器Map构造两个fill方法，gen产生填充的内容，count指定填充多少
	public static void fill(Collection<Object> c,Generator gen,int count){
		for (int i = 0; i < count; i++) {
			c.add(gen.next());
		}
	}
	
	public static void fill(Map<Object, Object> m,MapGenerator gen,int count){
		for (int i = 0; i < count; i++) {
			Pair p=gen.next();
			m.put(p.key,p.value);
		}
	}
	
	
	//下面是关于MapGenerator的具体实现
	//1.String 2.Random
	public static class RandStringPairGenerator implements MapGenerator{
		private Array2.RandStringGenerator gen;
		
		public RandStringPairGenerator(int len){
			gen=new Array2.RandStringGenerator(len);
		}
		
		public Pair next(){
			return new Pair(gen.next(), gen.next());
		}
	}
	
	//下面的实现没有随机，而是根据传入的一个二维数组来提取下一个pair
	public static class StringPairGenerator implements MapGenerator{
		private int index=-1;
		private String[][] data;
		
		public StringPairGenerator(String[][] d){
			data=d;
		}
		
		public StringPairGenerator reset(){
			index=-1;
			return this;
		}
		
		public Pair next(){
			index=(index+1) % data.length;
			String key=data[index][0];
			String value=data[index][1];
			return new Pair(key, value);
		}
	}

}
