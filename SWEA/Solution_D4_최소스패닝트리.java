package study_0316;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_D4_최소스패닝트리 {

	static class Node implements Comparable<Node>{
		int end;
		int weight;
		
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight-o.weight;
		}
		
		
	}
	
	static Queue<Node>[] graph;
	static long Answer;
	static int T,V,E;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1 ; t<=T; t++) {
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			V = Integer.parseInt(st.nextToken());
			E = Integer.parseInt(st.nextToken());
			
			graph = new LinkedList[V+1];
			for(int i = 1 ; i<=V;i++) {
				graph[i] = new LinkedList<>();
			}
			
			for(int i = 0 ; i<E;i++) {
				st = new StringTokenizer(in.readLine());
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				int weight = Integer.parseInt(st.nextToken());
				
				graph[start].add(new Node(end,weight));
				graph[end].add(new Node(start,weight));
			}
			
			PriorityQueue<Node> pq = new PriorityQueue<>();
			Set<Integer> answer = new HashSet<>();
			answer.add(1);
			while(!graph[1].isEmpty()) {
				pq.add(graph[1].poll());
			}
			
			int count = 1;
			Answer = 0;
			while(count<V) {
				
				Node temp = pq.poll();
				if(answer.contains(temp.end)) {
					continue;
				}
				
				Answer += temp.weight;
				answer.add(temp.end);
				count++;
				
				while(!graph[temp.end].isEmpty()) {
					pq.add(graph[temp.end].poll());
				}
			}
			
			System.out.println("#"+t+" "+Answer);
		}
	}
	
}
