package study_1203;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution_Go_2 {

	public static void main(String[] args) {
		
		int n = 60;
		System.out.println(Arrays.toString(solution(n)));
		
	}
	
	private static int[] solution(int n) {
		
		int max = n*n; // �ִ밪
		
		ArrayList<Integer> answer = new ArrayList<>();
		boolean[] isValid = new boolean[n+1];
		answer = dfs(answer,isValid,max,0,n,n-1);
		
		//ArrayList => �迭
		int[] result = new int[answer.size()];
		for(int i = 0 ; i<answer.size();i++) {
			result[i] = answer.get(i);
		}
		
		return result;
	}

	public static ArrayList<Integer> dfs(ArrayList<Integer> answer,boolean[] isValid, int max, int now,int n,int index) {
		
		//��������
		if(max == now) {
			for(int i = 1 ; i<n;i++) {
				if(isValid[i]) {
					answer.add(i);
				}
			}
				return answer;
		}
		
		for(int i = index; i>0;i-- ) {
				//���� �������ٸ� ���̻� ���� �����ʰ� ����
				if(!answer.isEmpty()) 
					return answer;
				
				if(!isValid[i]&&max>=now+(i*i)) {
					isValid[i] = true;
					answer = dfs(answer,isValid,max,now+(i*i),n,index-1);
					isValid[i] = false;
				}
		}
		
		return answer;
		
	}
}
