package study_1201;

import java.util.Arrays;

public class Solution_go {
	public static void main(String[] args) {
//		int[] data = {50, 55, 56, 57, 58};
//		int many = 3;
//		int max = 163;
//		int[] data = {50};
//		int many = 3;
//		int max = 163;
		int[] data = {91, 74, 73, 85, 73, 81, 87};
		int many = 3;
		int max = 230;
		System.out.println(solution(max,many,data));
	}
	

	public static int solution(int max, int many,int[] data) {
		
		boolean[] isValid = new boolean[data.length];
		int[] answerList = new int[many];
		int now = 0;
		
		int answer = dfs(many,0,isValid,data,answerList,max,now);
		if(answer == 0) {
			return -1;
		}
		else {
			return answer;
		}
	}
	
	public static int dfs(int many, int depth, boolean[] isValid,int[] data,int[] answer,int max,int now) {
		if(depth == many) {
			int sum = 0;
			for(int i = 0 ; i<answer.length;i++) {
				sum +=answer[i];
			}
			
			if(sum<=max) {
				return Integer.max(sum, now);
			}
			
			return now;
		}
		
		for(int i = 0 ;i<data.length;i++) {
			if(!isValid[i]) {
				isValid[i] = true;
				answer[depth] = data[i];
				now = dfs(many,depth+1,isValid,data,answer,max,now);
				answer[depth] = 0;
				isValid[i] = false;
			}
		}
		
		return now;
	}
}
