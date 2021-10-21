package algo_study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_9282_珥肄由욧낵嫄댄щ {

	static int T;//?泥댄?
	static int N, M;//???
	static int[][] map;//???
	static int ans;//??
	static int[][][][] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][M];
			dp = new int[N + 1][M + 1][N + 1][M + 1];
			for (int[][][] d1 : dp) {
				for (int[][] d2 : d1) {
					for (int[] d3 : d2) {
						Arrays.fill(d3, Integer.MAX_VALUE);
					}
				}
			}

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			ans = dfs(0, 0, N, M);

			System.out.println("#" + t + " " + ans);
		}

	}
	
	private static int dfs(int y, int x, int h, int w) {
		if (w == 1 && h == 1) {
			return 0;
		}
		
		if (dp[y][x][h][w] != Integer.MAX_VALUE) {
			return dp[y][x][h][w];
		}

		// 湲곗〈? ?? ?⑹대━? 嫄댄щ 媛?
		int sum = 0;
		for (int i = y; i < y + h; i++) {
			for (int j = x; j < x + w; j++) {
				sum += map[i][j];
			}
		}
		
		// 媛濡濡 ???댁 理? 鍮?⑹ 援ы??
		for (int i = 1; i < h; i++) {
			// ?履쎈???
			int sum1 = dfs(y, x, i, w);
			// ??履?鍮??
			int sum2 = dfs(y + i, x, h - i, w);

			int sum3 = sum + sum1 + sum2;
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}

		// ?몃?濡 ???댁 理? 鍮?⑹ 援ы??
		for (int i = 1; i < w; i++) {
			// ?쇱そ鍮??
			int sum1 = dfs(y, x, h, i);
			// ?ㅻⅨ履?鍮??
			int sum2 = dfs(y, x + i, h, w - i);

			int sum3 = sum + sum1 + sum2;
			dp[y][x][h][w] = Math.min(dp[y][x][h][w], sum3);
		}

		return dp[y][x][h][w];
	}

}
