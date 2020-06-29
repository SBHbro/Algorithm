package algo_study_0625;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_D4_7699_수지의수지맞는여행 {

	static int T; // 총 테스트 케이스 수
	static int R, C; // 행열
	static char[][] map;
	static int[] dx = { 0, 0, -1, 1 }; // 상하좌우 검사 용도
	static int[] dy = { -1, 1, 0, 0 };
	static boolean[] visited; // 방문했는지 확인
	static int answer;

	// 'A' = 65
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {

			StringTokenizer st = new StringTokenizer(in.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());

			// 배열 및 변수 초기화
			map = new char[R][C];
			visited = new boolean[26];
			answer = 1;

			// 배열에 값 넣기
			for (int i = 0; i < R; i++) {
				map[i] = in.readLine().toCharArray();
			}

			// 첫번째 장소 방문한것으로 체크
			visited[map[0][0] - 65] = true;
			dfs(0, 0, 1);

			// 답
			System.out.println("#" + t + " " + answer);
		}
	}

	private static void dfs(int i, int j, int depth) {
		// 현재 depth와 answer를 비교해서 더 큰값을 넣는다.
		answer = Math.max(depth, answer);

		// 알파벳이 26개밖에 없기 때문에 26이 되면 종료
		if (answer == 26) {
			return;
		}

		// 포문을 4번 돌며 상하좌우에 갈수 있는곳이 있는지 검사하고 있다면 그곳으로 이동한다.
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

	// 이동할 곳의 좌표가 배열의 범위 안에 있는지 검사
	private static boolean isSafe(int ty, int tx) {
		return 0 <= ty && ty < R && 0 <= tx && tx < C;
	}

}
