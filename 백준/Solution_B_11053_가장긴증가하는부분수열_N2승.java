package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_11053_가장긴증가하는부분수열_N2승 {

	static int N;
	static int[] data;
	static int[] dp;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N+1];
		dp = new int[N+1];
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i = 1; i<=N;i++) {
			data[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 1 ; i<=N;i++) {
			int temp = 0;
			for(int j = 0 ; j<i;j++) {
				if(data[j]<data[i])
					if(dp[temp]<dp[j])
						temp = j;
			}
			dp[i] = dp[temp]+1;
			answer = Math.max(dp[i], answer);
		}
		
		System.out.println(answer);
		
	}
	
}
