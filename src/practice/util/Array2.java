package practice.util;

import java.util.Random;


public class Array2 {

	//fill the object array a with the object generated by gen
	public static void fill(Object[] a,Generator gen){
		fill(a, 0, a.length, gen);
	}
	public static void fill(Object[] a, int from, int to, Generator gen){
		for(int i=from;i<to;i++)
			a[i]=gen.next();
	}
	
	
	//以下内容是Generator的具体实例，即next方法产生的数是随机的
	//generator可以是随机的实现，也可以是其他的实现
	private static final String SSOURCE="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static char[] src=SSOURCE.toCharArray();
	
	private static Random r=new Random();
	
	//随意生成一个字符
	public static class RandCharGenerator implements Generator{
		public Object next() {
			return src[r.nextInt(src.length)];
		}
	}
	
	//randStringGenerator 是一个内部类，它的next方法调用RandCharGenerator
	//生成一个长度为len的String
	public static class RandStringGenerator implements Generator{
		private int len;
		private RandCharGenerator rg=new RandCharGenerator();
		
		public RandStringGenerator(int length){
			len=length;
		}
		
		public Object next() {
				char[] buf=new char[len];
				for (int i = 0; i < buf.length; i++) {
					buf[i]=(char)rg.next();
				}
				
				return new String(buf);
		}
		
	}

}


