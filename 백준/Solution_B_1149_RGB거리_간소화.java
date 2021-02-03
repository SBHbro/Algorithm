package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_1149_RGB거리_간소화 {

	static int[][] data;
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = Integer.parseInt(st.nextToken());
		}
		
		dp[0][0] = data[0][0];
		dp[0][1] = data[0][1];
		dp[0][2] = data[0][2];
		
		for(int i = 1;i<N;i++) {
			for(int j = 0 ; j<3;j++) {
				dp[i][j] = Math.min(dp[i-1][(j+1)%3],dp[i-1][(j+2)%3])+data[i][j];
			}
		}
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}
	
}
