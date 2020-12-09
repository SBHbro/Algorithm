package algo_study_0714;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_B_15649_N��M2 {

	static int End, depth; // 1���� End���� depth ���� ����.
	static int[] array;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		End = Integer.parseInt(st.nextToken());
		depth = Integer.parseInt(st.nextToken());

		array = new int[depth + 1];

		dfs(0, 0);
	}

	private static void dfs(int tmp, int start) {
		if (tmp == depth) { // depth���� �̾Ҵٸ� ���
			for (int i = 0; i < tmp; i++) {
				System.out.print(array[i] + " ");
			}
			System.out.println();
			return;
		}

		for (int i = start + 1; i <= End; i++) {
			array[tmp] = i;
			dfs(tmp + 1, i);
		}
	}

}
