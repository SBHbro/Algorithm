package study_1130;

import java.util.Arrays;

public class Solution_Go {
	
	private static int solution(int[] data, int n) {
		
		int answer = 0;
		while(!isEnd(data)) {
			int pointer = 0;
			for(int i = 0 ; i<n;i++) {
				while(pointer<data.length&&data[pointer]==0) {
					pointer++;
				}
				if(pointer>=data.length)
					break;
				data[pointer]--;
				pointer++;
			}
			answer++;
//			System.out.println(Arrays.toString(data));
		}
		
		
		return answer;
	}
	
	private static boolean isEnd(int[] data) {
		
		for(int i = 0 ; i<data.length;i++) {
			if(data[i]!=0) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] data = new int[] {2,10,7,4,6,3,2,4,5,2,3,4,1,6,7,12,13};
//		int[] data = new int[] {1,2,3,4,5};
//		int[] data = new int[] {41,16,13,11,4,13,30,25,47,39,45,43,50,16,40,3,4,47,40,32};
//		int[] data = new int[] {5,3,4};
//		int[] data = new int[] {10,2,3,3};
		int n = 2;
//		int n = 4;
		
		System.out.println(solution(data,n));
	}
}
