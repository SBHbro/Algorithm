package study_1220;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_2206_벽부수고이동하기_완 {

	static int[][] map;
	static int[][][] visited;
	static int N, M;
	static int answer;
	static int[] dy = new int[] { -1, 1, 0, 0 };
	static int[] dx = new int[] { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		map = new int[N][M];
		visited = new int[2][N][M];

		for (int i = 0; i < N; i++) {
			String temp = in.readLine();
			for (int j = 0; j < M; j++) {
				map[i][j] = temp.charAt(j) - '0';
			}
		}

		for (int z = 0; z < 2; z++) {
			for (int i = 0; i < N; i++) {
				Arrays.fill(visited[z][i], Integer.MAX_VALUE);
			}
		}

		visited[0][0][0] = 1;
		visited[1][0][0] = 1;

		bfs();
		
		answer = Math.min(visited[0][N - 1][M - 1], visited[1][N - 1][M - 1]);
		if (answer != Integer.MAX_VALUE) {
			System.out.println(answer);
		} else
			System.out.println(-1);

	}

	private static void bfs() {
		Queue<int[]> que = new LinkedList<int[]>();

		que.add(new int[] { 0, 0, 1, 0 });

		while (!que.isEmpty()) {

			int[] temp = que.poll();
			for (int i = 0; i < 4; i++) {
				int ty = dy[i] + temp[0];
				int tx = dx[i] + temp[1];
					// 벽을 부수지 않고 온 경우
					if ((temp[3] == 0)) {
						// 나보다 값이 클때만
						if (isSafe(ty, tx)&&temp[2] + 1 < visited[0][ty][tx]) {
							// 길로갈때
							if (map[ty][tx] == 0) {
								visited[0][ty][tx] = temp[2] + 1;
								que.add(new int[] { ty, tx, temp[2] + 1, 0 });
							}
							// 벽하나 뚫을때
							else if (map[ty][tx] == 1) {
								visited[1][ty][tx] = temp[2] + 1;
								que.add(new int[] { ty, tx, temp[2] + 1, 1 });
							}
						}
					}
					// 벽을 부수고 온 경우
					else {
						// 길이여야 하고 거기 값이 나보다 작아야 함
						if (isSafe(ty, tx)&&map[ty][tx] == 0 && temp[2] + 1 < visited[1][ty][tx]) {
							visited[1][ty][tx] = temp[2] + 1;
							que.add(new int[] { ty, tx, temp[2] + 1, 1 });
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
