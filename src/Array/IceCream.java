package Array;

import java.util.*;

public class IceCream {

	private static Random rand=new Random();
	private static final String[] flavors=new String[]{
		"Cholocate","StrawBerry","Mud Pie","Mint Chip"
	};
	
	/**
	 * pick n elements from flavors and store them in an array
	 * this method must be static so that we would't new an object to call
	 * @param n
	 * @return
	 */
	public static String[] flavorSet(int n){
		String[] result=new String[n];
		boolean[] picked=new boolean[flavors.length];
		for(int i=0;i<n;i++){
			int t;
			//avoid repeating choice
			do {
				t=rand.nextInt(flavors.length);
			} while (picked[t]);
			
			result[i]=flavors[t];
			picked[t]=true;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		//print 20 flavorset to verify that all of them are random
		for (int i = 0; i < 20; i++) {
			String[] fl=flavorSet(flavors.length);
			
			System.out.println("flavorSet("+i+")=");
			for (int j = 0; j < fl.length; j++) {
				System.out.println("\t"+fl[j]);
			}
		}
	}

}
