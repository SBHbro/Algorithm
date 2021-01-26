package study_0126;

import java.util.Arrays;

public class Solution_H_LeftRotation {
	
	public static void main(String[] args) {
		
		System.out.println(Arrays.toString(rotLeft(new int[] {1,2,3,4,5},4)));
	}
	
	static int[] rotLeft(int[] a, int d) {

		int[] answer = new int[a.length];
		int point = d;
		
		
		for(int i = 0 ; i<a.length;i++) {
			answer[i] = a[point];
			point++;
			if(a.length<=point)point = 0;
		}
		
		
		return answer;
    }
}
