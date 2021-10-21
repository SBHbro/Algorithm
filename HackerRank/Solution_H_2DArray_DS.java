package study_0126;

public class Solution_H_2DArray_DS {
	public static void main(String[] args) {
	}
	
	static int plusGlass(int[][] arr, int y, int x) {
		int result = 0;
		for(int i = y ; i<y+3;i++) {
			for(int j = x; j<x+3;j++) {
				result+= arr[i][j];
			}
		}
		result -= arr[y+1][x];
		result -= arr[y+1][x+2];
		return result;
	}

	static int hourglassSum(int[][] arr) {

		int answer = Integer.MIN_VALUE;
		
		for(int i = 0 ; i<4;i++) {
			for(int j = 0;j<4;j++) {
				answer = Math.max(answer, plusGlass(arr,i,j));
				
			}
		}
		
		
		return answer;
	}
}
