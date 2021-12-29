package study_1229;

public class Solution_P_정수삼각형 {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));
	}
	
	public static int solution(int[][] triangle) {
		int answer = 0;
		for (int i = 0; i < triangle.length - 1; i++) {
			int[] temp = triangle[i + 1].clone();
			for (int j = 0; j < triangle[i].length; j++) {
				if (triangle[i + 1][j] < triangle[i][j] + temp[j]) {
					triangle[i + 1][j] = triangle[i][j] + temp[j];
					answer = Math.max(answer, triangle[i + 1][j]);
				}
				if (triangle[i + 1][j + 1] < triangle[i][j] + temp[j + 1]) {
					triangle[i + 1][j + 1] = triangle[i][j] + temp[j + 1];
					answer = Math.max(answer, triangle[i + 1][j + 1]);
				}
			}
		}

		return answer;
	}
}
