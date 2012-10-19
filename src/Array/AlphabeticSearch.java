package Array;

import java.util.*;

import practice.util.Array2;

//ʵ����Comparator�ӿڣ��Ӷ���������Ͳ���
class AlphabeticComporator implements Comparator<String>{
	public int compare(String a,String b){
		return a.toLowerCase().compareTo(b.toLowerCase());
	}
}

public class AlphabeticSearch {

	public static void main(String[] args) {
		String[] a=new String[10];
		//���
		Array2.fill(a, new Array2.RandStringGenerator(a.length));
		AlphabeticComporator comp=new AlphabeticComporator();
		//����
		System.out.println("before sorting: "+Arrays.asList(a));
		Arrays.sort(a, comp);
		System.out.println("after sorting: "+Arrays.asList(a));
		//����
		int index=Arrays.binarySearch(a, a[5], comp);
		System.out.println("Index = "+index);
	}

}
