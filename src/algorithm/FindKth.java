package algorithm;

import static org.junit.Assert.*;

import org.junit.Test;

/*
 * 找到一个数组中的第k大的数
 */
public class FindKth {

	public int quickSort(int[] a, int start, int end) {
		int pivot = a[start], i = start, j = end;
		while(i<j) {
			while(i<j && a[j]>=pivot) {j--;}
			a[i] = a[j];
			while(i<j && a[i]<=pivot) {i++;}
			a[j] = a[i];
		}
		a[i] = pivot;
		return i;
	}
	
	public int findKthNumber(int[]a, int k) {
		int len = a.length;
		if(len==0 || k<=0 || k>len) return -1;
		int start = 0, end = len-1;
		while(start <= end){
			int index = quickSort(a, start, end);
			if(len-index == k) return a[index];
			else if(len-index > k){
				start = index+1;
			}else{
				end = index-1;
			}
		}
		return -1;
	}
	
	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public void print(int[] a) {
		System.out.print("[");
		for (int i = 0; i < a.length; i++) {
			if(i!=0) System.out.print(", ");
			System.out.print(a[i]);
		}
		System.out.println("]");
	}
	
	public int testGeneric(int[] a, int k) {
		System.out.println("原来的数组：");
		print(a);
		System.out.print("第"+k+"个数：");
		int ret =findKthNumber(a, k);
		System.out.println(ret);
		return ret;
	}
	
	@Test
	public void testOrdered() {
		int[] a = {3,4,5,8,13,24,99};
		assertEquals(testGeneric(a, 4),8);
	}
	
	@Test
	public void testDisOrder() {
		int[] a = {35,23,7,42,55,1,9};
		assertEquals(testGeneric(a, 4),23);
	}
	
	@Test
	public void testDuplicate() {
		int[] a = {5,8,4,5,4,8,8,5,5,5,4,4};
		assertEquals(testGeneric(a, 4),5);
	}
}
