package study_0302;

import java.util.Arrays;

public class Solution_P_징검다리 {

	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		int left, right, middle;
		left = 0;
		right = distance;

		while (left <= right) {

			middle = (left + right) / 2;

			int prev = 0;
			int cnt = 0;

			for (int i = 0; i < rocks.length; i++) {
				if (rocks[i] - prev < middle) {
					cnt++;
				} else if (middle <= rocks[i] - prev) {
					prev = rocks[i];
				}
			}

			if (distance - prev < middle) {
				cnt++;
			}

			if (n < cnt) {
				right = middle - 1;
			} else {
				left = middle + 1;
				answer = middle;
			}

		}
		return answer;
	}
}
