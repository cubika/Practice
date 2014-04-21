package algorithm;

import java.util.ArrayList;
import java.util.Stack;

public class MaximalRect {

	public static int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[][] data = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j]== '1' ){
					if( j == 0) {
						data[i][j] = 1;
					}else {
						data[i][j] = data[i][j-1] + 1;
					}
				}
			}
		}
        
        for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(matrix[i][j]== '1' ){
					int currentI = i;
					int minWidth = data[i][j];
					while( currentI >= 0 && matrix[currentI][j] == '1'){
						minWidth = Math.min(minWidth, data[currentI][j]);
						int area = minWidth * (i-currentI+1);
						if (area > maxArea) {
							maxArea = area;
						}
						currentI--;
					}
				}
			}
		}
        return maxArea;
    }

	public String longestPalindrome(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                if(i>=j) dp[i][j]=true;
                else dp[i][j]=false;
            }
        }
        int lStart = 0,lEnd = 0;
        for(int len=2;len<=s.length();len++){
            for(int i=0;i<s.length();i++){
                int j = i+len-1;
                if(j>= s.length()) break;
                if(s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                    if(dp[i][j] && (j-i)>(lEnd-lStart)){
                        lEnd = j;
                        lStart = i;
                    }
                }else{
                    dp[i][j] = false;
                }
            }
        }
        return s.substring(lStart,lEnd+1);
    }
	
	public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        int m=matrix.length,n=matrix[0].length;
        boolean[][] visited = new boolean[m][n];
        int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
        int i=0,j=0;
        int curDir = 0;
        while(true){
//            if( (i==0||visited[i-1][j]) && (i==m-1||visited[i+1][j]) && (j==0||visited[i][j-1]) && (j==n-1||visited[i][j+1]) )
//                break;
        	if(i<0 || i>=m || j<0 || j>=n || visited[i][j]) break;
            result.add(matrix[i][j]);
            visited[i][j] = true;
            int nextI = i+dir[curDir][0],
                nextJ = j+dir[curDir][1];
            if(nextI<0 || nextI>=m || nextJ<0 || nextJ>=n || visited[nextI][nextJ]){
                curDir = (curDir+1)%4;
                i = i+dir[curDir][0];
                j = j+dir[curDir][1];
            }else{
                i = nextI;
                j = nextJ;
            }
        }
        return result;
    }
    
	public static void printNRadix(int n){
		if (n<0) return ;
		if(n==0){
			System.out.println("1");
			return;
		}
		char[] str = new char[n];
		str[0] = '0';
		int radixCount = 1;
		while(radixCount <= n){
			int i = 0;
			while(i<n && str[i]=='9'){
				str[i] = '0';
				i++;
			}
			if(i >= n) break;
			if(i >= radixCount){
				radixCount++;
			}
			if(str[i]>='1' && str[i]<='9'){
				str[i] = (char) (str[i] + 1);	
			}else{
				str[i] = '1';
			}
			for(int j=n-1;j>=0;j--){
				if(str[j]>='0' && str[j]<='9')
					System.out.print(str[j]);
			}
			System.out.println();
		}
	}
	
	public static void reverseStackRecursive(Stack<Integer> stack){
		if(stack.isEmpty()) return;
		int tmp1 = stack.pop();
		reverseStackRecursive(stack);
		if(stack.size()==0){
			stack.push(tmp1);
			return;
		}
		int tmp2 = stack.pop();
		reverseStackRecursive(stack);
		stack.push(tmp1);
		reverseStackRecursive(stack);
		stack.push(tmp2);
	}
    
	public static int findTarget(int[] data){
		if(data.length < 1) return -1;
		int nTimes = 0;
		int result = 0;
		for(int i=0;i<data.length;i++){
			if(nTimes==0){
				nTimes = 1;
				result = data[i];
			}else{
				if(data[i] == result)
					nTimes++;
				else
					nTimes--;
			}
		}
		return result;
	}
	
	 public static int rectRecursive(int[] height,int start,int end){
	        if(start == end) return height[start];
	        int min = height[start], minIndex = start;
	        for(int i=start+1;i<=end;i++){
	            if(height[i] < min){
	                min = height[i];
	                minIndex = i;
	            }    
	        }
	        int area1 = (end-start+1)*min;
	        int areaLeft = 0, areaRight = 0;
	        if(start <= minIndex-1){
	            areaLeft = rectRecursive(height,start,minIndex-1);
	        }
	        if(minIndex+1 <= end){
	            areaRight = rectRecursive(height,minIndex+1,end);
	        }
	        return Math.max(area1,Math.max(areaLeft,areaRight));
	    }
	
	 public static int largestRectangleArea(int[] height) {
	        int max = 0;
	        Stack<Integer> indexStack = new Stack<Integer>();
	        Stack<Integer> heightStack = new Stack<Integer>();
	        for(int i=0;i<height.length;i++){
	            if(heightStack.isEmpty() || height[i]>heightStack.peek()){
	                indexStack.push(i);
	                heightStack.push(height[i]);
	            }else if(height[i]<heightStack.peek()){
	                int lastIndex = 0;
	                while(!heightStack.isEmpty() && height[i]<heightStack.peek()){
	                    lastIndex = indexStack.pop();
	                    int h = heightStack.pop();
	                    int w = i - lastIndex;
	                    max = Math.max(max,w*h);
	                }
	                heightStack.push(height[i]);
	                indexStack.push(lastIndex);
	            }
	        }
	        while(!indexStack.isEmpty()){
	            int lastIndex = indexStack.pop();
	            int w = height.length - lastIndex;
	            int h = heightStack.pop();
	            max = Math.max(max,w*h);
	        }
	        return max;
	    }
	
	
	 public static String multiply(String num1, String num2) {
		int len1 = num1.length(), len2 = num2.length();
	    int[] num1Arr = new int[len1];
	    int[] num2Arr = new int[len2];
	    for(int i=len1-1;i>=0;i--){
	    	num1Arr[len1-1-i] = num1.charAt(i)-'0';
	    }
	    for(int i=len2-1;i>=0;i--){
	    	num2Arr[len2-1-i] = num2.charAt(i)-'0';
	    }
	    int capacity = len1 * len2;
	    if(len1==1){
	    	capacity = len2 + 1;
	    }else if(len2==1){
	    	capacity = len1 + 1;
	    }
	    int[] result = new int[capacity];
	    for(int i=0;i<len1;i++){
	    	int carry = 0;
	    	for(int j=0;j<len2;j++){
	    		int temp = result[i+j] + num1Arr[i]*num2Arr[j] + carry;
	    		result[i+j] = temp%10;
	    		carry = temp/10;
	    	}
	    	if(carry!=0){
	    		result[i+len2] = carry;
	    	}
	    }
	    StringBuffer sBuffer = new StringBuffer();
	    int i = result.length - 1;
	    while(i>=0&&result[i]==0){i--;}
	    while(i>=0){
	    	sBuffer.append(result[i]);
	    	i--;
	    }
	    if(sBuffer.length()==0) return "0";
	    else return sBuffer.toString();
	 }
	 
	 
	 public static int divide(int dividend, int divisor) {
	        boolean negative = false;
	        if((dividend>0&&divisor<0) || (dividend<0&&divisor>0))
	            negative = true;
	        long a = dividend,b = divisor;
	        if(a<0) a = -a;
	        if(b<0) b= -b;
	        int result = 0;
	        if(a<b) return 0;
	        while(a>=b){
	            int count = 0;
	            while(a >= b<<(count+1)){ count++;}
	            a -= b<<count;
	            result += 1<<count;
	        }
	        return negative? -result : result;
	    }
	 
	public static void main(String[] args) {
//		String[] input = {"101001110","111000001","001100011","011001001","110110010","011111101","101110010","111010001","011110010","100111000"};
//		char[][] data = new char[input.length][input[0].length()];
//		for(int i=0;i<input.length;i++){
//			data[i] = input[i].toCharArray();
//		}
//		System.out.println(maximalRectangle(data));
		
//		System.out.println(new MaximalRect().longestPalindrome("bbbba"));
//		int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
//		System.out.println(new MaximalRect().spiralOrder(matrix));
		
//		printNRadix(9);

//		Stack<Integer> stack = new Stack<Integer>();
//		stack.push(1);
//		stack.push(2);
//		stack.push(3);
//		System.out.println(stack);
//		reverseStackRecursive(stack);
//		System.out.println(stack);
		
//		int[] data = {1,2,3,3,2,3,3,3,3,2,3,3,4,3,4,5,6,3,4,5,2,3,4,3,3,3,2,3,1,3,2,3,8,5,3,6,7,3,5,5};
//		System.out.println(findTarget(data));
		
		int[] data = {2,1,2};
		System.out.println(largestRectangleArea(data));
		
//		System.out.println(multiply("9", "6"));
		
//		System.out.println(divide(-1010369383, -2147483648));
	}

}
