package study_0126;

public class Solution_H_CountingValleys {

	public static void main(String[] args) {
		System.out.println(countingValleys(8, "UDDDUDUU"));
	}

	public static int countingValleys(int steps, String path) {

		int answer = 0;

		int height = 0;
		for (int i = 0; i < path.length(); i++) {
			if (path.charAt(i) == 'D') {
				if (height == 0)
					answer++;
				height--;
			} else
				height++;
		}

		return answer;

	}

}
