package algorithm;

import org.junit.Test;

/**
 * 
 * @author Administrator
 * 从无序数组中找到两个数的和为sum
 */
public class FindTwoNum {

	/**
	 * 思路：借用hash思想，开辟长度为sum的Boolean数组，遇到值比sum大的则跳过；否则设置sum-a[i]的值为true
	 * 当扫描到a[i]的hash为true时，说明之前有过一个元素的值为sum-a[i]
	 */
	public void findTwoSum(int a[], int sum) {
		int len = a.length;
		boolean b[] = new boolean[sum+1];
		for(int i=0; i<len; i++) {
			if(a[i] > sum){
				continue;
			}
			if(b[a[i]] == true){
				System.out.println("The two numbers are: " + a[i] + " and " + (sum-a[i]));
				break;
			}else{
				b[sum-a[i]] = true;
			}
		}
	}

	@Test
	public void test(){
		int[] a = {3,4,15,2,27,7,34,19,11,17};
		findTwoSum(a, 24);
	}
}
