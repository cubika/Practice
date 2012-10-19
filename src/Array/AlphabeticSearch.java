package Array;

import java.util.*;

import practice.util.Array2;

//实现了Comparator接口，从而利于排序和查找
class AlphabeticComporator implements Comparator<String>{
	public int compare(String a,String b){
		return a.toLowerCase().compareTo(b.toLowerCase());
	}
}

public class AlphabeticSearch {

	public static void main(String[] args) {
		String[] a=new String[10];
		//填充
		Array2.fill(a, new Array2.RandStringGenerator(a.length));
		AlphabeticComporator comp=new AlphabeticComporator();
		//排序
		System.out.println("before sorting: "+Arrays.asList(a));
		Arrays.sort(a, comp);
		System.out.println("after sorting: "+Arrays.asList(a));
		//查找
		int index=Arrays.binarySearch(a, a[5], comp);
		System.out.println("Index = "+index);
	}

}
