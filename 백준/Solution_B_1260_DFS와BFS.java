package algo_study_0705;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_1260_DFS와BFS {
	static int N; // 정점의 개수
	static int M; // 간선의 개수
	static int start; // 시작 정점
	static ArrayList<Integer>[] data; // 간선 저장
//	static List<ArrayList<Integer>> data;
	static boolean[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		start = Integer.parseInt(st.nextToken());

		data = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		for (int i = 0; i < data.length; i++) {
			data[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) { // 간선 정보 입력
			st = new StringTokenizer(in.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());

			data[s].add(e);
			data[e].add(s);
		}

		for (int i = 0; i < data.length; i++) {
			Collections.sort(data[i]);
		}

//		for (int i = 1; i < data.length; i++) { // 출력
//			System.out.print(i + " : ");
//			for (int j = 0; j < data[i].size(); j++) {
//				System.out.print(data[i].get(j) + " ");
//			}
//			System.out.println();
//		}

		dfs(start);
		System.out.println();
		visited = new boolean[N + 1];
		bfs(start);

	}

	private static void bfs(int s) {
		Queue<Integer> que = new LinkedList<Integer>();

		que.add(s);
		visited[s] = true;
		while (!que.isEmpty()) {
			int temp = que.poll();

			for (int i = 0; i < data[temp].size(); i++) {
				if (!visited[data[temp].get(i)]) {
					que.add(data[temp].get(i));
					visited[data[temp].get(i)]=true;
				}
			}

			System.out.print(temp + " ");

		}
	}

	private static void dfs(int s) {

		visited[s] = true;
		System.out.print(s + " ");
		for (int i = 0; i < data[s].size(); i++) {
			if (!visited[data[s].get(i)])
				dfs(data[s].get(i));
		}
	}

}
