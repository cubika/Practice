package algorithm;

import org.junit.Test;

/**
 * 
 * @author Administrator
 * �������������ҵ��������ĺ�Ϊsum
 */
public class FindTwoNum {

	/**
	 * ˼·������hash˼�룬���ٳ���Ϊsum��Boolean���飬����ֵ��sum�������������������sum-a[i]��ֵΪtrue
	 * ��ɨ�赽a[i]��hashΪtrueʱ��˵��֮ǰ�й�һ��Ԫ�ص�ֵΪsum-a[i]
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
