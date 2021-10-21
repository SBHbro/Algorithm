package study_0312;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_다항식계산 {

	static int T;
	static int N,M;
	static long[][] dp;
	static int[][] source;
	static long[] inputX;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1 ; t<=T;t++) {
			
			N = Integer.parseInt(in.readLine());

			source = new int[N + 1][3];

			StringTokenizer st;
			for (int i = 2; i <= N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < 3; j++) {
					source[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			M = Integer.parseInt(in.readLine());

			inputX = new long[M];
			st = new StringTokenizer(in.readLine());
			for (int i = 0; i < M; i++) {
				inputX[i] = Integer.parseInt(st.nextToken());
			}

			dp = new long[N + 1][M];
			Arrays.fill(dp[0], 1);
			dp[1] = inputX.clone();
			for (int i = 2; i <= N; i++) {
				Arrays.fill(dp[i], -1);
			}
			
//			for(long[] a : dp) {
//				System.out.println(Arrays.toString(a));
//			}

			System.out.print("#" + t + " ");
			for (int i = 0; i < M; i++) {
				dp[N][i] = function(N, i);
				System.out.print(dp[N][i]%998244353 + " ");
			}
			System.out.println();
		}
		
		
	}

	private static long function(int n, int i) {
		
		if(n==0)return 1;
		if(n==1)return dp[n][i];
		
		dp[source[n][1]][i] = dp[source[n][1]][i]!=-1?dp[source[n][1]][i] :function(source[n][1],i);
		dp[source[n][2]][i] = dp[source[n][2]][i]!=-1?dp[source[n][2]][i] : function(source[n][2],i);
		long ai = dp[source[n][1]][i];
		long bi = dp[source[n][2]][i];
		
		
		if(source[n][0] == 1) {
			return ai+bi;
		}
		else if(source[n][0] == 2) {
			return source[n][1] * bi;
		}
		else if(source[n][0] == 3) {
			return ai*bi;
		}
		
		return 0;
	}
}
