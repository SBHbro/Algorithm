package algo_study_0716;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_14503_로봇청소기 {

	static int N, M;// 맵의 크기
	static int d; // 로봇이 바라보는 방향
	static int ry, rx; // 로봇의 위치
	static int[][] map;
	static int answer;

	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	// 0 북 1 동 2 남 3 서
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(in.readLine());
		ry = Integer.parseInt(st.nextToken());
		rx = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());

		answer = 0;
		map = new int[N][M];

		// 빈칸 0 벽 1
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go();
		System.out.println(answer);

	}

	private static void go() {
		
		boolean isEnd = false;
		while(!isEnd) {
			if(map[ry][rx]==0) {
				answer++;
			}
			map[ry][rx] = 2;
			isEnd = false;
			boolean rotateEnd = false;
			for (int i = 0; i < 4; i++) {
				int td = d - 1;
				if (td == -1) {
					td = 3;
				}
				int ty = ry + dy[td];
				int tx = rx + dx[td];

				if (isSafe(ty, tx) && map[ty][tx] == 0) {
					ry = ty;
					rx = tx;
					d = td;
					rotateEnd = true;
					break;
				}
				d=td;
			}
			
			if(rotateEnd)
				continue;
			
			int ty = ry+(dy[d]*-1);
			int tx = rx+(dx[d]*-1);
			if(map[ty][tx] != 1) {
				ry = ty;
				rx = tx;
				continue;
			}
			else
				isEnd=true;
		}
	}

	private static boolean isSafe(int ty, int tx) {
		// TODO Auto-generated method stub
		return 0 <= ty && ty < N && 0 <= tx && tx < M;
	}

}
