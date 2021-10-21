package study_0306;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P_N으로표현 {

	// N에서 출발해서 0을 만드는 방법
	// dp 를 32000짜리 배열 생성
	// 큐에 N, N*11 n*111,n*1111,n*11111(범위조건에 맞을때만) 을 넣는다
	// 꺼내서 사칙연산을 통해 큐에 넣는다(범위조건)(그자리의 뎁스가 나보다 크거나 0일때만)
	// 도달하면 종료 혹은 9이상이면 종료

	public static void main(String[] args) {

		System.out.println(solution(5, 66));

	}

	public static int solution(int N, int number) {
		int[] dp = new int[288001];
		System.out.println(N + " " + number);

		Queue<int[]> que = new LinkedList<int[]>();

		que.add(new int[] { 0, 0 });

		while (!que.isEmpty()) {
			int[] temp = que.poll();
			if (dp[temp[0]] != 0 && dp[temp[0]] < temp[1])
				continue;
			if (dp[temp[0]] == 0)
				dp[temp[0]] = temp[1];
			if (temp[0] == number) {
				dp[temp[0]] = Math.min(dp[temp[0]], temp[1]);
				continue;
			}

			if (8 < temp[1])
				continue;

			// 곱셈,나눗셈,덧셈,뺄셈 순
			int tmp = 11111;
			for (int i = 5; i > 0; i--) {
				if (temp[0] * N * tmp < 288001 && temp[1] + i < 9 && dp[temp[0] * N * tmp] < temp[1] + i) {
					que.add(new int[] { temp[0] * N * tmp, temp[1] + i });
				}
				if (temp[0] * tmp < 288001 && temp[1] + i + 1 < 9 && dp[temp[0] * tmp] < temp[1] + i + 1) {
					que.add(new int[] { temp[0] * tmp, temp[1] + i + 1 });
				}
				tmp /= 10;
			}
			tmp = 11111;
			for (int i = 5; i > 0; i--) {
				if (temp[0] / (N * tmp) > 0 && temp[1] + i < 9 && dp[temp[0] / (N * tmp)] < temp[1] + i) {
					que.add(new int[] { temp[0] / (N * tmp), temp[1] + i });
				}
				if (temp[0] / tmp > 0 && temp[1] + i + 1 < 9 && dp[temp[0] / tmp] < temp[1] + i + 1) {
					que.add(new int[] { temp[0] / tmp, temp[1] + i + 1 });
				}
				tmp /= 10;
			}
			tmp = 11111;
			for (int i = 5; i > 0; i--) {
				if (temp[0] + N * tmp < 288001 && temp[1] + i < 9 && dp[temp[0] + N * tmp] < temp[1] + i) {
					que.add(new int[] { temp[0] + N * tmp, temp[1] + i });
				}
				if (temp[0] + tmp < 288001 && temp[1] + i + 1 < 9 && dp[temp[0] + tmp] < temp[1] + i + 1) {
					que.add(new int[] { temp[0] + tmp, temp[1] + i + 1 });
				}
				tmp /= 10;
			}
			tmp = 11111;
			for (int i = 5; i > 0; i--) {
				if (temp[0] - N * tmp > 0 && temp[1] + i < 9 && dp[temp[0] - N * tmp] < temp[1] + i) {
					que.add(new int[] { temp[0] - N * tmp, temp[1] + i });
				}
				if (temp[0] - tmp > 0 && temp[1] + i + 1 < 9 && dp[temp[0] - tmp] < temp[1] + i + 1) {
					que.add(new int[] { temp[0] - tmp, temp[1] + i + 1 });
				}
				tmp /= 10;
			}

		}
		if (dp[number] != 0 && dp[number] < 9)
			return dp[number];
		else
			return -1;
	}

}
