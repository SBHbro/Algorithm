package study_0127;

import java.util.Arrays;

public class Solution_H_MaxMin {

	// 정렬을시킨다.
	// 0부터 n-k까지가면서 최소값확인

	public static void main(String[] args) {

		System.out.println(maxMin(3,new int[] {10,100,300,200,1000,20,30}));
		System.out.println(maxMin(3,new int[] {1000000000,1000000000,1000000000}));
		
	}

	static int maxMin(int k, int[] arr) {
		
		int answer = Integer.MAX_VALUE;
		
		Arrays.sort(arr);
		
		for(int i = 0 ; i<=arr.length-k;i++) {
			answer = Math.min(answer, arr[i+k-1]-arr[i]);
		}
		
		System.out.println(Arrays.toString(arr));
		
		
		return answer;
	}

}
