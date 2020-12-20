package study_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_2206_벽부수고이동하기4 {

	static int[][] map;
	static int[][] isValid;
	static int N, M;
	static int answer;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		isValid = new int[N][M];
		visited = new boolean[N][M];

		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		answer = -1;
		for (int i = 0; i < N; i++) {
			Arrays.fill(isValid[i], Integer.MAX_VALUE);
		}
		isValid[0][0] = 1;

		bfs();
		if (isValid[N - 1][M - 1] != Integer.MAX_VALUE) {
			System.out.println(isValid[N - 1][M - 1]);
		} else
			System.out.println(-1);

	}

	private static void bfs() {

		Queue<int[]> que = new LinkedList<int[]>();
		Queue<int[]> que2 = new LinkedList<int[]>();

		que.add(new int[] { 0, 0, 1, 0 });

		while (!que.isEmpty()) {

			int[] temp = que.poll();

			for (int i = 0; i < 4; i++) {
				int ty = dy[i] + temp[0];
				int tx = dx[i] + temp[1];

				if (isSafe(ty, tx)) {
					// 벽을 부수지 않고 온 경우
					if ((temp[3] == 0)) {
						// 나보다 값이 클때만
						if (temp[2] + 1 <= isValid[ty][tx]) {
							isValid[ty][tx] = temp[2] + 1;
							// 길로갈때
							if (map[ty][tx] == 0) {
								que.add(new int[] { ty, tx, temp[2] + 1, 0 });
							}
							// 벽하나 뚫을때
							else if (map[ty][tx] == 1) {
								que.add(new int[] { ty, tx, temp[2] + 1, 1 });
							}
						}
						if (map[ty][tx] == 0 && !visited[ty][tx]) {
							visited[ty][tx] = true;
							que.add(new int[] { ty, tx, temp[2] + 1, 0 });
						}

					}
					// 벽을 부수고 온 경우
					else if (temp[3] == 1) {
						// 길이여야 하고 거기 값이 나보다 작아야 함
						if (map[ty][tx] == 0 && temp[2] + 1 < isValid[ty][tx]) {
							isValid[ty][tx] = temp[2] + 1;
							que.add(new int[] { ty, tx, temp[2] + 1, 1 });
						}
					}
				}
			}

		}

	}

	private static boolean isSafe(int y, int x) {
		// TODO Auto-generated method stub
		return 0 <= y && y < N && 0 <= x && x < M;
	}
}
