package algo_study_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D5_1247_최적경로 {

	static int T; // 테스트 케이스 수
	static int startX, startY, endX, endY; // 시작위치, 종료위치
	static int N; // 방문해야하는 수
	static boolean[] visited;
	static int ans;
	static ArrayList<int[]> node;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());

		for (int t = 1; t <= T; t++) {
			N = Integer.parseInt(in.readLine());
			StringTokenizer st = new StringTokenizer(in.readLine());
			ans = Integer.MAX_VALUE;
			node = new ArrayList<>();
			visited = new boolean[N];

			// 시작위치와 종료 위치
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			// 방문해야할 노드
			for (int i = 0; i < N; i++) {
				node.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			dfs(startX, startY, 0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}

	}

	// 완전탐색
	private static void dfs(int startX, int startY, int now, int depth, int distance) {

		//현재까지의 이동거리
		int nowDistance;
		if (depth != 0) {
			nowDistance = distance + Math.abs(node.get(now)[0] - startX) + Math.abs(node.get(now)[1] - startY);
		} else {
			nowDistance = 0;
		}

		// 종료조건
		if (ans < distance) {
			return;
		}
		if (depth == N) { // 깊이가 N보다 크거나 같으면 종료
			// 현재 최소값과 지금 루트의 최소값을 비교해서 더 작은것을 최소값에 넣는다
			distance = nowDistance + (Math.abs(node.get(now)[0] - endX) + Math.abs(node.get(now)[1] - endY));
			if (ans > distance) {
				ans = distance;
			}
			return;
		}

		//N개에 대해서 완전탐색
		for (int i = 0; i < N; i++) {

			//방문했던 곳은 넘어간다.
			if (visited[i]) {
				continue;
			}

			visited[i] = true;
			if (depth == 0) {
				dfs(startX, startY, i, depth + 1, nowDistance);
			} else {
				dfs(node.get(now)[0], node.get(now)[1], i, depth + 1, nowDistance);
			}
			visited[i] = false;
		}

	}

}
