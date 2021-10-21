package algo_study_0629;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Solution_B_2583_??援ы湲?{

	static int M, N, K; // Y,X, ?ш???媛?
	static int[][] map; // 留?
	static ArrayList<Integer> ans; // ??
	static int[] dx = { 0, 0, -1, 1 }; // ?대
	static int[] dy = { -1, 1, 0, 0 };
	static int cnt; // 遺由щ ??? 媛?

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		// 媛 珥湲고
		map = new int[M][N];
		ans = new ArrayList<Integer>();
		ans.add(1);

		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(in.readLine());
			int sx = Integer.parseInt(st.nextToken());
			int sy = M - Integer.parseInt(st.nextToken());
			int ex = Integer.parseInt(st.nextToken());
			int ey = M - Integer.parseInt(st.nextToken());
//			System.out.println(sx + " "+ sy + " " + ex + " " +ey +" "+ (ey-sy) + " "+ (ex-sx));

			for (int y = 0; y < Math.abs(ey - sy); y++) {
				for (int x = 0; x < Math.abs(ex - sx); x++) {
					map[ey + y][sx + x] = -1;
				}
			}
		}

		for(int i = 0 ; i<M;i++) {
			System.out.println(Arrays.toString(map[i]));
		}

		//?? ??
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 0) {
					cnt = 1;
					dfs(i, j);
					ans.add(cnt);
				}
			}
		}
		
		for(int i = 0 ; i<M;i++) {
			System.out.println(Arrays.toString(map[i]));
		}
		ans.remove(0);
		Collections.sort(ans);

		if (ans.size() > 0) {
			System.out.println(ans.size());
			for (int i = 0; i < ans.size(); i++) {
				System.out.print(ans.get(i) + " ");
			}
		} else {
			System.out.println(0);
		}

	}

	private static void dfs(int y, int x) {
		map[y][x] = cnt;
		for (int k = 0; k < 4; k++) {
			int ty = y + dy[k];
			int tx = x + dx[k];
			if (isSafe(ty, tx) && map[ty][tx] == 0) {
				cnt++;
				dfs(ty, tx);
			}
		}

	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < M && 0 <= tx && tx < N;
	}

}
