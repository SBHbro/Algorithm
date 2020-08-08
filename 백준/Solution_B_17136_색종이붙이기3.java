package algo_study_0728;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_B_17136_색종이붙이기3 {

	static int[][] map;
	static int N = 10;
	static int ans;
	static int[] paper;
	static boolean isAns;

	// 색종이의 크기는 1.1 2.2 3.3 4.4 5.5
	// 맵은 10x10
	// 10x10 맵을 색종이 큰것부터 2중포문으로 돌며 색종이로 덮을 수 있는지 검사
	// 덮을 수 있을 경우 그부분을 모두 0 으로 변경
	// 마지막에 1이 있는지 확인한 후 있으면 ans 없으면 -1출력
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		map = new int[N][N];
		paper = new int[5];
		ans = Integer.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		Arrays.fill(paper, 5);

		dfs(0, 0, map, 0, 0);

		if (ans == Integer.MAX_VALUE)
			System.out.println(-1);
		else
			System.out.println(ans);
	}

	private static void dfs(int y, int x, int[][] map, int k, int ta) {
//	
//		System.out.println("y : " + y + " x " + x + " k : " + k + " ans : " + ans + " t : " + ta);
//		print(map);
		if (k > 15)
			return;
		if (isAns && k >= ans) {
			return;
		}

		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				if (map[i][j] == 1) {
					for (int t = 4; t >= 0; t--) {
						if (paper[t] == 0)
							continue;
						// 안전하고 모두 1일경우
						if (isSafe(i + t, j + t) && check(i, j, t, map)) {
							// 맵 복사해서 보내고 배열[t]를 1줄인다
							// dfs소환
							// 배열 t++
							int[][] map2 = new int[N][N];
							for (int z = 0; z < N; z++) {
								map2[z] = map[z].clone();
							}
							paint(i, j, t, map2);
							if (k + 1 < ans) {
								paper[t]--;
								dfs(i, j, map2, k + 1, t);
								paper[t]++;
							}

						}
//						else break;
					}
					return;
				}
			}
		}

		// 다 돌았을때 검사
		// 답이 한번이라도 있었으면 -1은아님
		if (answer(map)) {
			ans = Math.min(ans, k);
			isAns = true;
		} else {
			if (!isAns)
				ans = -1;
		}

	}

	public static void print(int[][] map) {
		for (int i = 0; i < 10; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		System.out.println(Arrays.toString(paper));
		System.out.println();
	}

	private static boolean answer(int[][] map) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1)
					return false;
			}
		}
		return true;
	}

	private static void paint(int y, int x, int k, int[][] map) {
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				map[i][j] = 0;
			}
		}
	}

	private static boolean check(int y, int x, int k, int[][] map) {

		int tmp = 0;
		for (int i = y; i <= y + k; i++) {
			for (int j = x; j <= x + k; j++) {
				if (map[i][j] == 1)
					tmp++;
				else {
					return false;
				}
			}
		}
		if (tmp == (k + 1) * (k + 1))
			return true;

		return false;
	}

	private static boolean isSafe(int i, int j) {
		// TODO Auto-generated method stub
		return 0 <= i && i < N && 0 <= j && j < N;
	}

}
