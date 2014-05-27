package algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Test;

/**
 * 
 * �ж��������Ƿ�����ظ�������
 *
 */
public class IsDuplicated {

	/*
	 * ����һ�� ���������ж����ڵ�����
	 * �ռ临�Ӷ�O(1),ʱ�临�Ӷ�O(nlogn)
	 */
	public boolean isDuplicatedArray_1(int[] array) {
		Arrays.sort(array);
		if(array.length<=1) return false;
		for (int i = 1; i < array.length; i++) {
			if(array[i] == array[i-1])
				return true;
		}
		return false;
	}

	/*
	 * �������� ʹ��bitmap
	 * �ռ临�Ӷ�O(n),ʱ�临�Ӷ�O(n)
	 */
	public boolean isDuplicatedArray_2(int[] array) {
		BitSet bitSet = new BitSet();
		for (int i = 0; i < array.length; i++) {
			if(bitSet.get(array[i])) 
				return true;
			bitSet.set(array[i], true);
		}
		return false;
	}

	/*
	 * �������� ��������˼�룬ǰ��������a[N]�����е����ķ�Χ��1-N
	 * �ռ临�Ӷ�O(1),ʱ�临�Ӷ�O(n)
	 */
	public boolean isDuplicatedArray_3(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if(array[i] == i+1) continue;
			if(array[array[i]-1] == array[i]) return true;
			swap(array,i,array[i]-1);
			i--;
		}
		return false;
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	@Test
	public void test() {
		int[] array = {5,3,1,2,4};
		assertFalse(isDuplicatedArray_1(array));
		assertFalse(isDuplicatedArray_2(array));
		assertFalse(isDuplicatedArray_3(array));
		int[] array2 = {5,3,2,4,2};
		assertTrue(isDuplicatedArray_1(array2));
		assertTrue(isDuplicatedArray_2(array2));
		assertTrue(isDuplicatedArray_3(array2));
	}
}
