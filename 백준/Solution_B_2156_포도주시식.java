package study_0204;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution_B_2156_포도주시식 {

	static int N;
	static int[] data;
	static int[] dp;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(in.readLine());

		data = new int[N+3];
		dp = new int[N+3];
		for (int i = 3; i < N+3; i++) {
			data[i] = Integer.parseInt(in.readLine());
		}

		for (int i = 3; i < N+3; i++) {
			dp[i] = Math.max(dp[i - 3] + data[i - 1] + data[i], dp[i - 2] + data[i]);
			dp[i] = Math.max(dp[i], dp[i - 1]);
		}

		System.out.println(dp[N + 2]);

	}

}
