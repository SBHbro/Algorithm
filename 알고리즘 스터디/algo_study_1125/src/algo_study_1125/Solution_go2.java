package algo_study_1125;

import java.util.Arrays;

public class Solution_go2 {
	
	public static void main(String[] args) {
		
		int[] data = new int[] {1,2,3,4,5};
		int[] data2 = new int[] {-9, 9, -8, 8, 66, 23};
		
		solution(data2,1);
	}
	
	private static void solution(int[] data,int run) {
		
		int start = 0;
		int end = data.length-1;
		for(int i = 0 ; i<run;i++) {
			while(true) {
				if(start >= end) {
					start = 0;
					break;
				}
				data[start] = data[start]+data[end];
				data[end] = Integer.MAX_VALUE;
				start++;
				end--;
			}
		}
		int[] answer = Arrays.copyOf(data, end+1);
		
		System.out.println(Arrays.toString(answer));
	}
}
