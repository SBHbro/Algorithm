package algo_study_0624;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution_D5_1247_理?寃쎈? {

	static int T; // ??ㅽ?耳?댁??
	static int startX, startY, endX, endY; // ???移, 醫猷?移
	static int N; // 諛⑸Ц?댁쇳? ?
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

			// ???移? 醫猷 ?移
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());

			// 諛⑸Ц?댁쇳 ?몃
			for (int i = 0; i < N; i++) {
				node.add(new int[] { Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()) });
			}

			dfs(startX, startY, 0, 0, 0);

			System.out.println("#" + t + " " + ans);
		}

	}

	// ????
	private static void dfs(int startX, int startY, int now, int depth, int distance) {

		//??ш?吏? ?대嫄곕━
		int nowDistance;
		if (depth != 0) {
			nowDistance = distance + Math.abs(node.get(now)[0] - startX) + Math.abs(node.get(now)[1] - startY);
		} else {
			nowDistance = 0;
		}

		// 醫猷議곌굔
		if (ans < distance) {
			return;
		}
		if (depth == N) { // 源?닿? N蹂대??ш굅? 媛?쇰㈃ 醫猷
			// ???理?媛怨?吏湲 猷⑦몄 理?媛? 鍮援?댁 ? ??寃? 理?媛? ?ｋ??
			distance = nowDistance + (Math.abs(node.get(now)[0] - endX) + Math.abs(node.get(now)[1] - endY));
			if (ans > distance) {
				ans = distance;
			}
			return;
		}

		//N媛? ??댁 ????
		for (int i = 0; i < N; i++) {

			//諛⑸Ц?? 怨녹 ??닿???
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
