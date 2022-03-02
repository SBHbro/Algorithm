package study_0302;

public class Solution_P_순위 {
	public int solution(int n, int[][] results) {
		int answer = 0;

		int[][] fight = new int[n + 1][n + 1];
		for (int i = 0; i < results.length; i++) {
			fight[results[i][0]][results[i][1]] = 1;
			fight[results[i][1]][results[i][0]] = -1;
		}

		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (fight[i][k] == 1 && fight[k][j] == 1) {
						fight[i][j] = 1;
						fight[j][i] = -1;
					} else if (fight[i][k] == -1 && fight[k][j] == -1) {
						fight[i][j] = -1;
						fight[j][i] = 1;
					}
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (fight[i][j] == 0)
					cnt++;
			}
			if (cnt == 1)
				answer++;
		}

		return answer;
	}
}
