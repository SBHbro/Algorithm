package study_1229;

public class Solution_P_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
		int[] students = new int[n + 2];
		for (int i : lost) {
			students[i]--;
		}
		for (int i : reserve) {
			students[i]++;
		}

		for (int i = 1; i <= n; i++) {
			if (students[i] == 1) {
				if (students[i - 1] == -1) {
					students[i - 1]++;
					students[i]--;
					continue;
				}
				if (students[i + 1] == -1) {
					students[i + 1]++;
					students[i]--;
					continue;
				}
			}
		}

		for (int i = 1; i <= n; i++) {
			if (students[i] == 1)
				answer++;
		}

		return answer;
	}
}
