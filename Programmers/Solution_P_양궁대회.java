package study_220404;

import java.util.Arrays;
import java.util.List;

public class Solution_P_¾ç±Ã´ëÈ¸ {

	public static void main(String[] args) {
		int[] inputData = { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 };
		System.out.println(Arrays.toString(solution(5, inputData)));
	}

	public static int[] answer;
	public static int answerScore;

	public static int[] solution(int n, int[] info) {

		answer = new int[] { -1 };
		int[] lionTarget = new int[11];
		int lionLeftArrow = n;

		int[] apeachTarget = new int[11];
		for (int i = 0; i < info.length; i++) {
			apeachTarget[10 - i] = info[i];
		}

		dfs(lionLeftArrow, 10, lionTarget, apeachTarget);

		if (answerScore == 0)
			answer = new int[] { -1 };
		return answer;
	}

	public static void checkScore(int[] apeachTarget, int[] lionTarget) {
		int lionScore = 0;
		int apeachScore = 0;

		for (int i = 0; i < 11; i++) {
			if (apeachTarget[i] < lionTarget[i])
				lionScore += i;
			else if (apeachTarget[i] > lionTarget[i])
				apeachScore += i;
		}

		int diffScore = lionScore - apeachScore;

		if (answerScore <= diffScore) {

			if (answer.length == 11 && answerScore == diffScore) {
				for (int i = 0; i < 11; i++) {
					if (answer[10 - i] > lionTarget[i])
						return;
					else if (answer[10 - i] < lionTarget[i])
						break;
				}
			}

			answerScore = diffScore;

			answer = new int[11];
			for (int i = 0; i < lionTarget.length; i++) {
				answer[i] = lionTarget[10 - i];
			}

		}

	}

	public static void dfs(int leftArrow, int index, int[] lionTarget, int[] apeachTarget) {

		if (leftArrow < 0)
			return;
		if (leftArrow == 0) {

			checkScore(apeachTarget, lionTarget);

			return;
		}

		if (index == 0) {
			lionTarget[index] = leftArrow;
			checkScore(apeachTarget, lionTarget);
			lionTarget[index] = 0;
			return;
		}

		lionTarget[index] = apeachTarget[index] + 1;
		dfs(leftArrow - (apeachTarget[index] + 1), index - 1, lionTarget, apeachTarget);
		lionTarget[index] = 0;

		dfs(leftArrow, index - 1, lionTarget, apeachTarget);

	}

}
