package algorithm;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.BitSet;

import org.junit.Test;

/**
 * 
 * 判断数组中是否出现重复的数字
 *
 */
public class IsDuplicated {

	/*
	 * 方法一： 进行排序，判断相邻的数字
	 * 空间复杂度O(1),时间复杂度O(nlogn)
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
	 * 方法二： 使用bitmap
	 * 空间复杂度O(n),时间复杂度O(n)
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
	 * 方法三： 计数排序思想，前提条件，a[N]数组中的数的范围是1-N
	 * 空间复杂度O(1),时间复杂度O(n)
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
