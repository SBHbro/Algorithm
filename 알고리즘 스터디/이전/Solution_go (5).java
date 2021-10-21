package algo_study_1123;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_go {
	
	public static void main(String[] args) {
		int[][] test = exam(110);
		if(test!=null) {
			for(int i = 0 ; i<test.length;i++) {
				System.out.println(Arrays.toString(test[i]));
			}
		}
		else {
			System.out.println("null");
		}
	}

	private static int[][] exam(int N) {
		
		int maxValue = 0;
		
		for(int i = 1; i<=N;i++) {
			maxValue += i;
		}
		
		int[][] data = new int[N+1][N+1];
		List<int[]> answer = new ArrayList<int[]>();
		
		for(int i = 1 ; i<=N;i++) {
			for(int j = 1; j<=N;j++) {
				if(i!=j) {
					int temp = maxValue - (i+j);
					int temp2 = i*j;
					
					if(temp == temp2) {
						answer.add(new int[] {i,j});
					}
				}
			}
		}
		
		Collections.sort(answer,new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				// TODO Auto-generated method stub
				if(o1[0]>o2[0]) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		
		if(answer.size()==0) {
			return null;
		}
		else {
			int[][] temp = new int[answer.size()][2];
			for(int i = 0 ;i<answer.size();i++) {
				temp[i] = answer.get(i); 
			}
			return temp;
		}
	}
}
