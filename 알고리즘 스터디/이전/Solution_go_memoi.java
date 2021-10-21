package algo_study_1125;

import java.util.Arrays;

public class Solution_go_memoi {

	
	public static void main(String[] args) {
		int[] data = new int[] {4,7,2,9,5,2};
		int[] data2 = new int[] {10, 1000, 2};
		int[] data3 = new int[] {10, 1000, 2, 1};
		int[] data4 = new int[] {140, 649, 340, 982, 105, 86, 56, 610, 340, 879};
		System.out.println(Arrays.toString(solution(data4)));
	}
	
	private static int[] solution(int[] data) {
		int max = 0;
		for(int i = 0 ; i< data.length;i++) {
			max += data[i];
		}
		
		int[][] memoi = new int[data.length][data.length];
		int A = dfs(data,0,data.length-1,memoi);
		int B = max-A;
		return new int[] {A,B};
	}
	
	public static int dfs(int[] data, int i, int j,int[][] memoi)
    {
        if (i == j) {
            return data[i];
        }
 
        if (i + 1 == j) {
            return Integer.max(data[i], data[j]);
        }
 
        if(memoi[i][j]==0) {
        	int start = data[i] + Integer.min(dfs(data, i + 2, j,memoi),
        			dfs(data, i + 1, j - 1,memoi));
        	int end = data[j] + Integer.min(dfs(data, i + 1, j - 1,memoi),
        			dfs(data, i, j - 2,memoi));
        	memoi[i][j] = Integer.max(start, end);
        }
 
        return memoi[i][j];
    }
}
