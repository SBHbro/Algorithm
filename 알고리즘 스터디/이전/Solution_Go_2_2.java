package study_1203;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Go_2_2 {

	public static void main(String[] args) {
		
		int n = 45;
		System.out.println(Arrays.toString(solution(n)));
		
	}
	
	private static int[] solution(int n) {
		// TODO Auto-generated method stub
		int max = n*n; // 최대값
		
		ArrayList<Integer> answer = new ArrayList<>();
		boolean[] isValid = new boolean[n+1];
		answer = dfs(answer,isValid,max,0,n,n-1);
		
		int[] test = new int[n+1];
		for(int i = 1 ; i<n+1;i++) {
			test[i] = i*i;
		}
		
		//ArrayList => 배열
		int[] result = new int[answer.size()];
		for(int i = 0 ; i<answer.size();i++) {
			result[i] = answer.get(i);
		}
		
		return result;
	}

	public static ArrayList<Integer> dfs(ArrayList<Integer> answer,boolean[] isValid, int max, int now,int n,int index) {
		
		
		
		if(max == now) {
//			if(!answer.isEmpty()&&answer.get(answer.size()-1)==n-1) {
//				return answer;
//			}
			ArrayList<Integer> temp = new ArrayList<>();
			for(int i = 1 ; i<n;i++) {
				if(isValid[i]) {
					temp.add(i);
				}
			}
			if(!answer.isEmpty()) {
				if(temp.get(temp.size()-1)>answer.get(answer.size()-1)) {
					return temp;
				}
				else {
					return answer;
				}
			}
			else {
				return temp;
			}
		}
		
		for(int i = index; i>0;i-- ) {
			System.out.println(i);
				if(!answer.isEmpty()&&answer.get(0)==1)
					return answer;
				//골라지지 않은 숫자일경우
				if(!isValid[i]&&max>=now+(i*i)) {
					isValid[i] = true;
					answer = dfs(answer,isValid,max,now+(i*i),n,index-1);
					isValid[i] = false;
				}
		}
		
		return answer;
		
	}
}
