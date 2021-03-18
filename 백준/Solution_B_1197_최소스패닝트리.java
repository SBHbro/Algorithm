package study_0318;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution_B_1197_최소스패닝트리 {
	//크루스칼 알고리즘으로 풀기
	//시작정점 도착정점 가중치를 모두 입력받는다.
	//[시작정점].도착[0,1,2]
	
	//간선의 길이 아니근데 간선의 개수가 많으면 프림알고리즘을 쓰라면서 왜 크루스칼로풀래
	//유니온파인드해야함
	//배열[정점의개수]
	//priority que를 사용해서 간선의 길이가 짧은 순으로 입력받는다.
	//가장 짧은것을 빼서 같은 루트를 가지고 있는지 확인하고 
	//다른 루트를 가질 경우 유니온 연산을 한다.
	//n-1개의 간선이 선택될때까지 반복
	
	static int[] unionArray;
	static int V,E;
	static PriorityQueue<int[]> pq;
	static long answer;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		
		unionArray = new int[V+1];
		for(int i = 1; i<V+1;i++) {
			unionArray[i] = i;
		}
		
		pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		
		for(int i = 0 ;i<E;i++) {
			st = new StringTokenizer(in.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			pq.add(new int[] {start,end,weight});
		}
		
		int count = 0;
		while(count<V-1) {
			int[] temp = pq.poll();
			if(find(temp[0])==find(temp[1])) {
				continue;
			}
			else {
				union(temp[0],temp[1]);
				answer+=temp[2];
				count++;
			}
		}
		
		System.out.println(answer);
		
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		
		unionArray[b] = a;
	}

	private static int find(int input) {
		
		if(unionArray[input] == input) {
			return input;
		}
		
		return unionArray[input]=find(unionArray[input]);
	}
}
