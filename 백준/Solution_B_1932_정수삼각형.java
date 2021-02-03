package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_1932_Á¤¼ö»ï°¢Çü {

	static int N;
	static int[][] data;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N][N];
		dp = new int[N][N];
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j=0;j<i+1;j++) {
				data[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0]= data[0][0];
		
		for(int i = 0 ; i<N-1;i++) {
			for(int j = 0 ; j<i+1;j++) {
				if(dp[i+1][j]<dp[i][j]+data[i+1][j])
					dp[i+1][j] = dp[i][j]+data[i+1][j];
				if(dp[i+1][j+1]<dp[i][j]+data[i+1][j+1])
					dp[i+1][j+1] = dp[i][j]+data[i+1][j+1];
			}
		}
		
		int answer = 0;
		
		for(int i = 0 ; i<N;i++) {
			answer = Math.max(dp[N-1][i],answer);
		}
		
		System.out.println(answer);
	}
	
}
