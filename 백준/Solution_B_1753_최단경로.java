package study_0317;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_B_1753_최단경로 {

	static class Node {
		List<int[]> end = new ArrayList<int[]>();
	}

	static int V, E;
	static int startNode;
	static int[] answer;

	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());

		startNode = Integer.parseInt(in.readLine());
		answer = new int[V + 1];
		Arrays.fill(answer, Integer.MAX_VALUE);
		Node[] node = new Node[V + 1];
		for(int i = 0;i<V+1;i++) {
			node[i] = new Node();
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			node[start].end.add(new int[] {end,weight});
		}
		
		answer[startNode] = 0;
		
		PriorityQueue<int[]> que = new PriorityQueue<int[]>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1]-o2[1];
			}
		});
		
		Set<Integer> isVisit = new HashSet<>(); 
		que.add(new int[] {startNode,0});
		
		//우선순위큐 -> 정점과 거기까지의 거리
		//처음에 0, startNode를 넣는다.
		while(!que.isEmpty()){
			//우선순위큐에서 뺀다.
			//뺏는데 걔가 이미 했던애이면 컨티뉴
			//아니면 걔를 기점으로 answer배열을 갱신한다.
			
			int[] temp = que.poll();
			int start= temp[0];
			if(isVisit.contains(start)) {
				continue;
			}
			isVisit.add(temp[0]);
			
			for(int i = 0 ; i<node[start].end.size();i++) {
				int end = node[start].end.get(i)[0];
				int weight = node[start].end.get(i)[1];
				if(answer[start]+weight<answer[end]) {
					answer[end] = answer[start]+weight;
					que.add(new int[] {end,answer[end]});
				}
			}
		}
		
		for(int i = 1;i<=V;i++) {
			if(answer[i]!=Integer.MAX_VALUE)
				out.write(answer[i]+"\n");
			else
				out.write("INF\n");
		}
		
		out.close();
	}

}
