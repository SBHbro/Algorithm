package study_1202;

import java.util.Arrays;

public class Solution_Go {

	
	public static void main(String[] args) {
	
//		int[] ls = new int[] {0,1,3,6,10};
		int[] ls = new int[] {744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358};
		System.out.println(Arrays.toString(solution(ls)));
	}

	private static int[] solution(int[] ls) {
		// TODO Auto-generated method stub
		
		int[] answer = new int[ls.length+1];
		
		for(int i = answer.length-2;i>=0;i--) {
			answer[i] += ls[i]+answer[i+1];
		}
		
		return answer;
	}
	
	
	
}
