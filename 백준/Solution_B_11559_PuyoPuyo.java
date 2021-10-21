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

	static Queue<int[]> que; // ??醫??媛 ? ??怨?泥댄?
	static Queue<int[]> que2; // 4媛?댁 媛 ? ??吏 泥댄?

	// 123諛蹂?
	// 1.?곗????寃??- ?щ?釉濡??媛???곗? ? ?? bfs濡 留듭 ?硫댁 ?臾몄?몄媛 ??ㅻ㈃ 4媛媛 ??醫?곕? 遺?댁?吏 ?? ?ｌ닿?硫?
	// 泥댄?
	// 泥댄ы? ?? ?ш린媛 4?댁??寃쎌??? ?ㅼ댁? 醫??ㅻ? isBomb諛곗?boolean)? T濡 諛袁쇰?
	// 2.?곕⑤━湲?- isBomb媛 T??醫??ㅼ map?? 'X'?쇰? 諛袁쇰?
	// 3.?대ㅼㅺ린 - map 諛곗댁 ??遺??泥댄ы硫댁 媛???怨 ??媛 'X'??寃쎌?'X'媛 ???源吏 諛?쇰? ?移몄⑹대

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
			// ?곗? ? ??吏 寃??
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (map[i][j] != '.' && !isBomb[i][j]) { // 鍮怨듦?????寃쎌?
						que.add(new int[] { i, j });
						isBomb[i][j] = true;
						bfs(map[i][j]);
						if (!que2.isEmpty() && que2.size() >= 4) { // 媛?? 議곌???4媛媛 ??寃쎌?
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

			if (checkBomb) { // ?곗? ? ?? ?留
				// ?곕⑤━湲?
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (isBomb[i][j]) {
							map[i][j] = '.';
							isBomb[i][j] = false;
						}
					}
				}

				// ?⑥대⑤━湲?
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
		
		//???異??
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
