package algo_study_0714;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Solution_B_15649_N과M3 {

	static int End, depth; // 1부터 End까지 depth 개를 고른다.
	static int[] array;

	static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		End = Integer.parseInt(st.nextToken());
		depth = Integer.parseInt(st.nextToken());

		array = new int[depth + 1];

		dfs(0,1);
		
		bw.flush();
		bw.close();
	}

	private static void dfs(int tmp, int start) throws IOException {
		if (tmp == depth) { // depth개를 뽑았다면 출력
				for (int i = 0; i < tmp; i++) {
					bw.write(String.valueOf(array[i])+ " ");
				}
				bw.newLine();
			return;
		}

		for (int i = start; i <= End; i++) {
			array[tmp] = i;
			dfs(tmp + 1, i);
		}
	}

}
