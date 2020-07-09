package algo_study_0708;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_B_11559_PuyoPuyo {

	static char[][] map;
	static boolean[][] isBomb;
	static int R = 12;
	static int C = 6;
	static boolean checkBomb;
	static int ans;

	static int[] dy = { -1, 1, 0, 0 };
	static int[] dx = { 0, 0, -1, 1 };

	static Queue<int[]> que; // 상하좌우 갈 수 있는곳 체크
	static Queue<int[]> que2; // 4개이상 갈 수 있는지 체크

	// 123반복
	// 1.터질애들 검사 - 여러 블록이 같이 터질 수 있음 bfs로 맵을 돌면서 영문자인애가 나오면 4개가 상하좌우로 붙어있는지 큐에 넣어가며
	// 체크
	// 체크후에 큐의 크기가 4이상일 경우 큐에 들어있는 좌표들로 isBomb배열(boolean)을 T로 바꾼다
	// 2.터뜨리기 - isBomb가 T인 좌표들을 map에서 'X'으로 바꾼다.
	// 3.내려오기 - map 배열의 아래부터 체크하면서 값이 있고 아래가 'X'인 경우 'X'가 아닐때까지 밑으로 한칸씩이동

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new char[R][C];
		isBomb = new boolean[R][C];
		que = new LinkedList<int[]>();
		que2 = new LinkedList<int[]>();
		ans = 0;

		for (int i = 0; i < R; i++) {
			map[i] = in.readLine().toCharArray();
		}

		checkBomb = true;

		while (checkBomb) {
			checkBomb = false;
			// 터질 수 있는지 검사
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != '.' && !isBomb[i][j]) { // 빈공간이 아닐경우
						que.add(new int[] { i, j });
						isBomb[i][j] = true;
						bfs(map[i][j]);
						if (!que2.isEmpty() && que2.size() >= 4) { // 같은색 조각이 4개가 넘을경우
							checkBomb = true;
							que2.clear();
						} else {
							while (!que2.isEmpty()) {
								int[] temp = que2.poll();
								isBomb[temp[0]][temp[1]] = false;
							}
						}
					}
				}
			}

			if (checkBomb) { // 터질 수 있을 때만
				// 터뜨리기
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (isBomb[i][j]) {
							map[i][j] = '.';
							isBomb[i][j] = false;
						}
					}
				}

				// 떨어뜨리기
				for (int i = R - 1; i >= 0; i--) {
					for (int j = 0; j < C; j++) {
						if (map[i][j] != '.') {
							int ty = i;
							int tx = j;
							while (isSafe(ty + 1, tx) && map[ty + 1][tx] == '.') {
								map[ty + 1][tx] = map[ty][tx];
								map[ty][tx] = '.';
								ty++;
							}
						}
					}
				}
				ans++;
			}

		}
		
		//정답 출력
		System.out.println(ans);

	}

	private static void bfs(char val) { 
		while (!que.isEmpty()) {
			int[] temp = que.poll();
			que2.add(temp);
			isBomb[temp[0]][temp[1]] = true;

			for (int d = 0; d < 4; d++) {
				int ty = temp[0] + dy[d];
				int tx = temp[1] + dx[d];

				if (isSafe(ty, tx) && map[ty][tx] == val && !isBomb[ty][tx]) {
					que.add(new int[] { ty, tx });
				}
			}

		}

	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < R && 0 <= tx && tx < C;
	}
}
