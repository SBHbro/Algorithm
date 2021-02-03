package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution_B_10844_쉬운계단수 {

	static int N;
	static long[][] dp;
	static long[] answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N= Integer.parseInt(in.readLine());
		
		dp = new long[N][10];
		answer = new long[N];
		
		for(int i = 1 ; i<=9;i++) {
			dp[0][i] = 1;
		}
		answer[0] = 9;
		
		for(int i = 1; i<N;i++) {
			long temp = 0;
			for(int j = 0 ; j<=9;j++) {
				long left = (-1==j-1) ? 0:dp[i-1][j-1]%1000000000;
				long right = (10==j+1) ? 0:dp[i-1][j+1]%1000000000;
				dp[i][j] = left+right;
				temp+=dp[i][j];
			}
			answer[i] = temp;
		}
		
		System.out.println(answer[N-1]%1000000000);
		
	}
}
