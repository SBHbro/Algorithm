package study_1021;

public class Solution_P_입국심사 {

	public static void main(String[] args) {
		int n = 10;
		int[] times = new int[] { 1, 2, 4, 7 };

		System.out.println(solution(n, times));
	}

	public static long solution(int n, int[] times) {

		int max = 0;

		for (int i = 0; i < times.length; i++) {
			max = Math.max(max, times[i]);
		}

		long minTime = 1;
		long maxTime = (long) max * n;

		return dfs(n, times, minTime, maxTime, maxTime);
	}

	public static long dfs(int n, int[] times, long start, long end, long ans) {

		if (start > end) {
			return ans;
		}

		long middle = (start + end) / 2;

		long man = 0;

		for (int i = 0; i < times.length; i++) {
			man += middle / times[i];
		}

		if (man < n) {
			return dfs(n, times, middle + 1, end, ans);
		} else {
			ans = Math.min(ans, middle);
			return dfs(n, times, start, middle - 1, ans);
		}
	}
}
