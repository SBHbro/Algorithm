package study_0315;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_D4_ÇÏ³ª·Î {

	static class Edge implements Comparable<Edge>{
		int node1,node2;
		double length;
		
		public Edge(int node1, int node2, double length) {
			super();
			this.node1 = node1;
			this.node2 = node2;
			this.length = length;
		}

		@Override
		public int compareTo(Edge that) {
			if(this.length-that.length>0)
				return 1;
			else if(this.length-that.length<0)
				return -1;
			else return 0;
		}

		@Override
		public String toString() {
			return "Edge [node1=" + node1 + ", node2=" + node2 + ", length=" + length + "]";
		}
		
	}
	
	static int T,N;
	static double E;
	static double Answer;
	static int[] unionFind;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(in.readLine());
		
		for(int t = 1 ; t<=T;t++) {
			
			N = Integer.parseInt(in.readLine());
			PriorityQueue<Edge> edge = new PriorityQueue<>();
			int[] X = new int[N];
			int[] Y = new int[N];
			unionFind = new int[N];
			
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i<N;i++) {
				X[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(in.readLine());
			for(int i = 0 ; i<N;i++) {
				Y[i] = Integer.parseInt(st.nextToken());
			}
			
			E = Double.parseDouble(in.readLine());
			
			for(int i = 0;i<N-1;i++) {
				for(int j = i+1; j<N;j++) {
					edge.add(new Edge(i,j,Math.sqrt(Math.pow(X[i]-X[j],2)+Math.pow(Y[i]-Y[j],2))));
				}
			}
			
			for(int i = 0 ; i<N;i++) {
				unionFind[i] = i;
			}
			
			int count = 0;
			Answer = 0;
			while(!edge.isEmpty()) {
				Edge temp = edge.poll();
				if(find(temp.node1)!=find(temp.node2)) {
					count++;
					union(temp.node1,temp.node2);
					Answer += Math.pow(temp.length,2)*E;
				}
				
				if(count==N-1)
					break;
				
			}
			System.out.print("#"+t+" ");
			System.out.println(Math.round(Answer));
			
		}
	}

	private static void union(int node1, int node2) {
		node1 = find(node1);
		node2 = find(node2);
		
		unionFind[node2] = node1;
	}

	private static int find(int x) {
		
		if(unionFind[x] == x) {
			return x;
		}
		else {
			return unionFind[x] = find(unionFind[x]);
		}
		
	}
	
}
