package algo_study_0709;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_19236_청소년상어 {

	// 1.dfs로 상어 집어넣음
	// 2.물고기 이동
	// 3.상어 이동할 수 있는 곳으로 새로 dfs

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
		// cnt에 현재 상어 위치의 숫자값 더함, 그위치의 물고기 사망, 사망한 물고기의 방향 상어가 가짐
		cnt += map2[y][x];
		int d = shark[map2[y][x]].d;
		shark[map2[y][x]].d = -1;
		map2[y][x] = 0;

		ans = Math.max(cnt, ans);

		if (d == -1)
			return;

		// 물고기 16마리 이동
		for (int i = 1; i < 17; i++) {

			// 물고기의 방향값이 -1이면 다음물고기로 넘어간다.
			if (shark[i].d == -1)
				continue;

			// 8방향으로 바꿔가면서 이동할 수 있는 곳으로 이동
			for (int j = 0; j < 8; j++) {
				// 이동 방향// 8을 넘어간다면 -8
				int td = shark[i].d + j;
				if (td >= 9)
					td = td % 8;
				int ty = shark[i].y + dy[td];
				int tx = shark[i].x + dx[td];

				// 물고기가 이동하려는곳이 맵의 범위 안에있고 상어가 있는 자리가 아니라면
				if (isSafe(ty, tx) && !(ty == y && tx == x)) {
					// 빈공간일때
					if (map2[ty][tx] == 0) {
						// 맵 값 교체
						map2[ty][tx] = i;
						map2[shark[i].y][shark[i].x] = 0;

						// shark배열의 값 변경
						shark[i].y = ty;
						shark[i].x = tx;
						shark[i].d = td;
					}
					// 다른 물고기가 있을 때
					else {
						// 맵 값 교체
						int temp = map2[ty][tx];
						map2[ty][tx] = i;
						map2[shark[i].y][shark[i].x] = temp;

						// shark배열의 값 변경
						int tempy = shark[i].y;
						shark[i].y = ty; // 이동한 곳의 y값을(ty) 넣어준다
						shark[temp].y = tempy; // 교체된 shark의 y값을(y) 넣어준다

						int tempx = shark[i].x;
						shark[i].x = tx; // 이동한 곳의 x값을(tx) 넣어준다
						shark[temp].x = tempx; // 교체된 shark의 x값을(x) 넣어준다

						shark[i].d = td;// 현재 d값을(td) 저장한다

					}
					// 다음 물고기로 넘어간다.
					break;
				}
			}

		}

		// 상어이동
		for (int i = 1; i < 4; i++) {
			int ty = y + (dy[d] * i);
			int tx = x + (dx[d] * i);
			// 상어가 map 범위안으로 이동하고 이동하려는 곳이 빈공간이 아닐 때 다음 depth로 이동
			if (isSafe(ty, tx) && map2[ty][tx] != 0) {

				// 배열은 인자로 넘겨진 배열의 값이 바뀌면 원래 배열의 값도 바뀌므로 똑같은 배열을 생성해서 넘겨준다.
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
