package algo_study_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_17136_색종이붙이기 {

	static int[][] map;
	static int N = 10;
	static int ans;
	static int[] paper;

	// 색종이의 크기는 1.1 2.2 3.3 4.4 5.5
	// 맵은 10x10
	// 10x10 맵을 색종이 큰것부터 2중포문으로 돌며 색종이로 덮을 수 있는지 검사
	// 덮을 수 있을 경우 그부분을 모두 0 으로 변경
	// 마지막에 1이 있는지 확인한 후 있으면 ans 없으면 -1출력
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		paper = new int[5];

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(paper, 5);
		for (int k = 4; k >= 0; k--) {
			roop(k);
//			for(int i=0;i<N;i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}
//			System.out.println();
		}

		if (!answer())
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static boolean answer() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static void roop(int k) {

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0)
					continue;

				if (map[i][j] == 1) {
					if (check(i, j, k)) {
						if (paper[k] > 0) {
							ans++;
							paint(i, j, k);
							paper[k]--;
							continue;
						}
					}
				}
			}
		}

	}

	private static void paint(int y, int x, int k) {
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static boolean check(int y, int x, int k) {

		int tmp = 0;
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				if (isSafe(i, j) && map[i][j] == 1)
					tmp++;
				else {
					return false;
				}
			}
		}
		if (tmp == (k+1) * (k+1))
			return true;

		return false;
	}

	private static boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return 0 <= i && i < N && 0 <= j && j < N;
	}

}
