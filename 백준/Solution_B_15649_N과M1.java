package algo_study_0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_15649_N과M1 {

	static int End, depth; // 1부터 End까지 depth 개를 고른다. (중복X)
	static int[] array;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		End = Integer.parseInt(st.nextToken());
		depth = Integer.parseInt(st.nextToken());
		
		
		array = new int[depth + 1];
		visited = new boolean[End+1];//방문했는지 확인

		dfs(0);
	}

	private static void dfs(int tmp) {
		if (tmp == depth) { // depth개를 뽑았다면 출력
			for (int i = 0; i < tmp; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = 1; i <= End; i++) {
			if (!visited[i]) {
				array[tmp] = i;
				visited[i] = true;
				dfs(tmp + 1);
				visited[i] = false;
			}
		}
	}

}
