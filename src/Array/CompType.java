package Array;

import java.util.*;

import practice.util.Array2;
import practice.util.Generator;

/**
 * CompType implements Comparable interface 
 * so that we can compare two CompType object.
 * @author Administrator
 *
 */
public class CompType implements Comparable<Object>{

	int i;
	int j;
	
	public CompType(int n1,int n2){
		i=n1;
		j=n2;
	}
	
	public int compareTo(Object rv) {
		int rvi=((CompType)rv).i;
		
		return (i<rvi) ? -1 : (i==rvi ? 0 : 1);
	}
	
	public String toString(){
		return "[i=" + i + " j=" + j + "]";
	}
	
	private static Random rand=new Random();
	
	//the generator() method specified how to generate a CompType object
	//并不是实例化了一个接口，而是实例化了一个“实现了接口的匿名内部类” ！！！
	//相当于private final class AnonymousClass implements Generator
	public static Generator generator(){
		return new Generator() {
			public Object next() {
				return new CompType(rand.nextInt(100), rand.nextInt(100));
			}
		};
	}
	
	public static void main(String[] args) {
		CompType[] a=new CompType[10];
		//call generator() method to use the Generator it returned 
		Array2.fill(a, generator());
		System.out.println("Before sorting :"+Arrays.asList(a));
		Arrays.sort(a);
		System.out.println("After sorting:"+Arrays.asList(a));
	}

}
