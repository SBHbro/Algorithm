package algo_study_0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_17471_게리맨더링 {

	
	static int N;
	static ArrayList<Integer>[] data;
	static boolean[] isVisit;
	static int[] left;
	static int[] right;
	static Node[] node;
	static int ans;

	static class Node{
		int line;
		ArrayList<Integer> to;
		int man;
		@Override
		public String toString() {
			return "Node [line=" + line + ", to=" + to.toString() + ", man=" + man + "]";
		}
		public Node() {
			super();
			this.line = 0;
			this.to = new ArrayList<>();
			this.man = 0;
		}
		
		
	}
	//1. 나눠본다
	//2. 나눈 구역이 모두 연결되어있는지 확인한다.
	//3. 최소값을 찾는다.
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		node = new Node[N];
		ans = Integer.MAX_VALUE;
		
		for(int i = 0 ; i<N;i++) {
			node[i] = new Node();
		}
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		for(int i =0;i<N;i++) {
			node[i].man = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0;i<N;i++) {
			st = new StringTokenizer(in.readLine());
			node[i].line = Integer.parseInt(st.nextToken());
			for(int j = 0 ; j<node[i].line ; j++) {
				node[i].to.add(Integer.parseInt(st.nextToken())-1);
			}
		}
		
		//N이 짝수일 때
		if(N%2==0) {
			for(int i = 1 ;i<=N/2;i++) {
				isVisit = new boolean[N];
				left = new int[i];
				right = new int[N-i];
				dfs(i,0);
			}
		}
		//N이 홀수일 때
		else if(N%2==1) {
			for(int i = 1 ;i<=(N/2)+1;i++) {
				isVisit = new boolean[N];
				left = new int[i];
				right = new int[N-i];
				dfs(i,0);
			}
		}
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		}
		else {
			System.out.println(ans);
		}
		
	}
	private static void dfs(int k,int depth) {
		if(k==depth) {
			int t = 0;
			for(int i = 0 ; i<N;i++) {
				if(!isVisit[i])
					right[t++]=i;
			}
			
			//모두 연결되어있는지 체크
			if(lineAll(left)) {
				if(lineAll(right)) {
					int temp = 0;
					for(int i = 0 ; i<left.length;i++) {
						temp += node[left[i]].man;
					}
					int temp2 = 0;
					for(int i = 0 ; i<right.length;i++) {
						temp2 += node[right[i]].man;
					}
					ans = Integer.min(ans, Math.abs(temp-temp2));
				}
			}
			return;
		}
		
		//나누기
		for(int i =depth;i<N;i++) {
			if(!isVisit[i]) {
				left[depth] = i;
				isVisit[i] = true;
				dfs(k,depth+1);
				isVisit[i] = false;
				
			}
		}
	}
	private static boolean lineAll(int[] arr) {
		int length = arr.length;
		boolean[] visited = new boolean[length];
		Queue<Integer> que = new LinkedList<>();
		//left 0번인덱스의 값을 que에 모두 넣는다.
		for(int i = 0;i<node[arr[0]].to.size();i++) {
			que.add(node[arr[0]].to.get(i));
		}
		//0번은 방문처리
		visited[0] = true;
		
		while(!que.isEmpty()) {
			int temp = que.poll();
			for(int i = 0 ; i<length;i++) {
				if(temp==arr[i]&&!visited[i]) {
					visited[i] = true;
					for(int j = 0;j<node[arr[i]].to.size();j++) {
						que.add(node[arr[i]].to.get(j));
					}
				}
			}
		}
		
		for(int i = 0 ;i<length;i++) {
			if(!visited[i])return false;
		}
		return true;
	}
	
}
