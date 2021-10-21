package algo_study_0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_19236_泥?????{

	// 1.dfs濡 ???吏?대ｌ
	// 2.臾쇨?湲??대
	// 3.????대? ? ?? 怨녹쇰? ?濡 dfs

	static int N = 4;
	static int ans;
	static int[] dy = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
	static int[] dx = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
	static int[][] map;

	static class Shark {
		int y;
		int x;
		int d;

		public Shark(int y, int x, int d) {
			super();
			this.y = y;
			this.x = x;
			this.d = d;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		map = new int[N][N];
		Shark[] shark = new Shark[17];
		shark[0] = new Shark(0, 0, -1);

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				map[i][j] = a;
				shark[a] = new Shark(i, j, b);
			}
		}

		ans = Integer.MIN_VALUE;

		dfs(0, 0, 0, shark, map, 1);

		System.out.println(ans);
	}

	private static void dfs(int y, int x, int cnt, Shark[] shark, int[][] map2, int test) {
		// cnt? ???????移? ?レ媛 ??? 洹몄移? 臾쇨?湲??щ?, ?щ?? 臾쇨?湲곗 諛⑺???닿? 媛吏
		cnt += map2[y][x];
		int d = shark[map2[y][x]].d;
		shark[map2[y][x]].d = -1;
		map2[y][x] = 0;

		ans = Math.max(cnt, ans);

		if (d == -1)
			return;

		// 臾쇨?湲?16留由??대
		for (int i = 1; i < 17; i++) {

			// 臾쇨?湲곗 諛⑺κ???-1?대㈃ ?ㅼ臾쇨?湲곕? ??닿???
			if (shark[i].d == -1)
				continue;

			// 8諛⑺μ쇰? 諛轅媛硫댁 ?대? ? ?? 怨녹쇰? ?대
			for (int j = 0; j < 8; j++) {
				// ?대 諛⑺?/ 8? ??닿??ㅻ㈃ -8
				int td = shark[i].d + j;
				if (td >= 9)
					td = td % 8;
				int ty = shark[i].y + dy[td];
				int tx = shark[i].x + dx[td];

				// 臾쇨?湲곌? ?대??ㅻ怨녹?留듭 踰? ???怨 ??닿? ?? ?由ш? ???쇰㈃
				if (isSafe(ty, tx) && !(ty == y && tx == x)) {
					// 鍮怨듦??쇰
					if (map2[ty][tx] == 0) {
						// 留?媛 援泥?
						map2[ty][tx] = i;
						map2[shark[i].y][shark[i].x] = 0;

						// shark諛곗댁 媛 蹂寃?
						shark[i].y = ty;
						shark[i].x = tx;
						shark[i].d = td;
					}
					// ?ㅻⅨ 臾쇨?湲곌? ?? ?
					else {
						// 留?媛 援泥?
						int temp = map2[ty][tx];
						map2[ty][tx] = i;
						map2[shark[i].y][shark[i].x] = temp;

						// shark諛곗댁 媛 蹂寃?
						int tempy = shark[i].y;
						shark[i].y = ty; // ?대? 怨녹 y媛?(ty) ?ｌ댁???
						shark[temp].y = tempy; // 援泥대 shark? y媛?(y) ?ｌ댁???

						int tempx = shark[i].x;
						shark[i].x = tx; // ?대? 怨녹 x媛?(tx) ?ｌ댁???
						shark[temp].x = tempx; // 援泥대 shark? x媛?(x) ?ｌ댁???

						shark[i].d = td;// ???d媛?(td) ??ν??

					}
					// ?ㅼ 臾쇨?湲곕? ??닿???
					break;
				}
			}

		}

		// ??댁대
		for (int i = 1; i < 4; i++) {
			int ty = y + (dy[d] * i);
			int tx = x + (dx[d] * i);
			// ??닿? map 踰???쇰? ?대?怨 ?대??ㅻ 怨녹?鍮怨듦????? ? ?ㅼ depth濡 ?대
			if (isSafe(ty, tx) && map2[ty][tx] != 0) {

				// 諛곗댁 ?몄濡 ?寃⑥? 諛곗댁 媛??諛?硫??? 諛곗댁 媛? 諛?誘濡 ?媛? 諛곗댁 ??깊댁 ?寃⑥???
				int[][] copyMap = new int[N][N];
				Shark[] copyShark = new Shark[17];

				for (int j = 0; j < 4; j++) {
					copyMap[j] = map2[j].clone();
				}

				for (int j = 0; j < 17; j++) {
					copyShark[j] = new Shark(shark[j].y, shark[j].x, shark[j].d);
				}

				dfs(ty, tx, cnt, copyShark, copyMap, test + 1);
			}
		}

	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < N && 0 <= tx && tx < N;
	}
}
