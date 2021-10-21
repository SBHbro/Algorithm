package algo_study_0714;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Solution_B_9663_NQueen {

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

		dfs(0, map,0,0);

		System.out.println(answer);

		long end = System.currentTimeMillis();
		System.out.println( "실행 시간 : " + ( end - start )/1000.0 );

	}

	private static void dfs(int k, int[][] map,int y,int x) {
		if (k == N) {
			answer++;
			return;
		}
		
		

		for (int i = y; i < N; i++) {
			for (int j = x; j < N; j++) {
				if (map[i][j]==0) {
//					boolean[][] map2 = new boolean[N][N];
//					for (int t = 0; t < N; t++) {
//						map2[t] = map[t].clone();
//					}
//					map2[i][j] = true;
					queen(map, i, j,0,k+1);
//					queen(map2, i, j,0,k+1);
					
					dfs(k + 1, map,i+1,0);
					
					queen(map,i,j,k+1,0);
				}
			}
		}
	}

	private static void queen(int[][] map, int y, int x,int start,int end) {
		for (int i = 0; i < 8; i++) {// 8방향
			for (int j = 1; j < N; j++) { // 1~N칸
				int ty = y + (dy[i] * j);
				int tx = x + (dx[i] * j);
				if (isSafe(ty, tx)&&map[ty][tx]==start) {
					map[ty][tx] = end;
				}
//				if (isSafe(ty, tx)) {
//					map[ty][tx] = true;
//				}
			}
		}
	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < N && 0 <= x && x < N;
	}

}
