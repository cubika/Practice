package practice.util;

import java.util.Collection;
import java.util.Map;

public class Collections2 {
	//�ֱ�Ϊ����Collection������Map��������fill������gen�����������ݣ�countָ��������
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
	
	
	//�����ǹ���MapGenerator�ľ���ʵ��
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
	
	//�����ʵ��û����������Ǹ��ݴ����һ����ά��������ȡ��һ��pair
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
