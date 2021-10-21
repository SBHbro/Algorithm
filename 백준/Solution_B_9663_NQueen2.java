package algo_study_0714;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_B_9663_NQueen2 {

	static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

	static int N;
	static int answer;
	static int[] dx = { 0, 1, 1, 1, 0, -1, -1, -1 };
	static int[] dy = { -1, -1, 0, 1, 1, 1, 0, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		long start = System.currentTimeMillis();

		N = Integer.parseInt(in.readLine());

		int[][] map = new int[N][N];
		answer = 0;

		dfs(0, map, 0, 0);

		System.out.println(answer);

		long end = System.currentTimeMillis();
		System.out.println("실행 시간 : " + (end - start) / 1000.0);

	}

	private static void dfs(int k, int[][] map, int y, int x) {
		if (k == N) {
			answer++;
			return;
		}
		
//		System.out.println(y+" "+x);
//		for(int i = 0 ; i<N;i++) {
//			System.out.println(Arrays.toString(map[i]));
//		}
//		System.out.println();
		
		for (int i = y; i < N; i++) {
			for (int j = x; j < N; j++) {
				if (map[i][j] == 0) {// 퀸을 놓을 수 있다면
					int[][] map2 = new int[N][N];
					for (int t = 0; t < N; t++) {
						map2[t] = map[t].clone();
					}
					map2[i][j] = 1;
					queen(map2,i,j);
					dfs(k + 1, map2, i + 1, 0);
				}
			}
		}
	}
	
	private static void queen(int[][] map, int y, int x) {
		for (int i = 0; i < 8; i++) {// 8방향
			for (int j = 1; j < N; j++) { // 1~N칸
				int ty = y + (dy[i] * j);
				int tx = x + (dx[i] * j);
				if (isSafe(ty, tx)&&map[ty][tx]==0) {
					map[ty][tx] = 1;
				}
			}
		}
	}

	private static boolean visit(int[][] map, int y, int x) {
		for (int i = 0; i < 8; i++) {// 8방향
			for (int j = 1; j < N; j++) { // 1~N칸
				int ty = y + (dy[i] * j);
				int tx = x + (dx[i] * j);
				if (isSafe(ty, tx) && map[ty][tx] == 1) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
