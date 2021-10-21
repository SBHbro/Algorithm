package algo_study_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_?吏??吏留??ы {

	static int T; // 珥 ??ㅽ?耳?댁??
	static int R, C; // ???
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 }; // ??醫??寃???⑸
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[] visited; // 諛⑸Ц??吏 ???
	static int answer;

	// 'A' = 65
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 諛곗?諛 蹂? 珥湲고
			map = new char[R][C];
			visited = new boolean[26];
			answer = 1;

			// 諛곗댁 媛 ?ｊ린
			for (int i = 0; i < R; i++) {
				map[i] = in.readLine().toCharArray();
			}

			// 泥ル?吏??μ 諛⑸Ц?寃?쇰? 泥댄?
			visited[map[0][0] - 65] = true;
			dfs(0, 0, 1);

			// ??
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int i, int j, int depth) {
		// ???depth? answer瑜?鍮援?댁 ? ?곌?? ?ｋ??
		answer = Math.max(depth, answer);

		// ??踰녹?26媛諛? ?湲??臾몄 26???硫?醫猷
		if (answer == 26) {
			return;
		}

		// ?щЦ? 4踰 ?硫???醫?곗 媛? ??怨녹???吏 寃?ы怨 ??ㅻ㈃ 洹멸납?쇰? ?대???
		for (int k = 0; k < 4; k++) {
			int ty = i + dy[k];
			int tx = j + dx[k];
			if (isSafe(ty, tx) && !visited[map[ty][tx] - 65]) {
				visited[map[ty][tx] - 65] = true;
				dfs(ty, tx, depth + 1);
				visited[map[ty][tx] - 65] = false;
			}
		}

	}

	// ?대? 怨녹 醫?媛 諛곗댁 踰? ?? ??吏 寃??
	private static boolean isSafe(int ty, int tx) {
		return 0 <= ty && ty < R && 0 <= tx && tx < C;
	}

}
