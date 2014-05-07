package algorithm;

import java.util.Random;

public class HeapSort {

	static void adjustHeap(int[] array, int start, int end){
		int i = start;
		while(i<=end){
			int left = i*2+1;
			int right = i*2+2;
			int largest = left;
			if(right<=end && array[left] < array[right]){
				largest = right;
			}
			if(largest<=end && array[i] < array[largest]){
				swap(array, largest, i);
				i = largest;
			}else{
				break;
			}
		}
	}
	
	static void heapSort(int[] array){
		int len = array.length;
		//construct heap
		for(int i=len/2; i>=0; i--){
			adjustHeap(array, i, len-1);
		}
		for(int j=len-1; j>=0; j--){
			//move the largest to the end
			swap(array, 0, j);
			adjustHeap(array, 0, j-1);
		}
	}
	
	static void swap(int[] array, int i, int j){
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	static void printArray(int[] array){
		System.out.print("[");
		for (int i = 0; i < array.length; i++) {
			if(i>0) System.out.print(",");
			System.out.print(array[i]);
		}
		System.out.print("]");
		System.out.println();
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] test = new int[10];
		Random rand = new Random();
		for (int i = 0; i < test.length; i++) {
			test[i] = rand.nextInt(100);
		}
		printArray(test);
		heapSort(test);
		printArray(test);
	}

}
