package algo_study_0626;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_D4_1226_誘몃?1_dfs {

	static int N = 16;
	static int[][] map;
	static int[] dx = { 0, 0, -1, 1 };
	static int[] dy = { -1, 1, 0, 0 };
	static int ans;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		for (int t = 1; t <= 10; t++) {
			// ??ㅽ몄??댁?踰?몃??遺遺
			in.readLine();

			// 蹂? 珥湲고
			map = new int[N][N];
			visited = new boolean[N][N];
			ans = 0;

			// ?곗댄????
			for (int i = 0; i < N; i++) {
				String input = in.readLine();
				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(input.charAt(j) + "");
				}
			}

//			for (int i = 0; i < N; i++) {
//				System.out.println(Arrays.toString(map[i]));
//			}

			dfs(1, 1);
			System.out.println("#"+t+" "+ans);
		}

	}

	private static void dfs(int y, int x) {
		
		//?李⑹??? 留?硫?1 濡 諛轅以??
		if (map[y][x] == 3) {
			ans = 1;
		}
		
		//?대??李⑹??? 留? 寃쎌?由ы?
		if (ans == 1) {
			return ;
		}

		for (int k = 0; k < 4; k++) {//??醫??
			int ty = y + dy[k];
			int tx = x + dx[k];

			if (isSafe(ty, tx) && map[ty][tx]!=1&&visited[ty][tx]==false) {
				visited[ty][tx]=true;
				dfs(ty,tx);
			}
		}
	}

	private static boolean isSafe(int ty, int tx) {
		return 0 <= ty && ty < N && 0 <= tx && tx < N;
	}
}
