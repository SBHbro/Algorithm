package algo_study_0809;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_D4_Contact {

	static class Node{
		ArrayList<Integer> go;
		public Node() {
			super();
			this.go = new ArrayList<>();
		}
	}
	
	static int start; // ������
	static int ans;
	static Node[] data;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		for(int t = 1; t<=10;t++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			
			//�Է¹��� ���̿� ������ �Է�
			int length = Integer.parseInt(st.nextToken());
			start = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(in.readLine());
			data = new Node[101];
			ans = 0;
			visited = new boolean[101];
			
			for(int i = 0 ; i<101;i++) {
				data[i] = new Node();
			}
			
			for(int i = 0; i<length/2;i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				
				data[from].go.add(to);
			}
			
			
//			for(int i = 1 ; i<101;i++) {
//				System.out.println(i+" : "+data[i].go.toString());
//			}
			bfs(start);
//			System.out.println(data[start].go.toString());
			System.out.println("#"+t+" "+ans);
		}
	}

	private static void bfs(int s) {
		
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<Integer> que2 = new LinkedList<Integer>();
		
		//�������� �ִ´�.
		que.add(s);
		visited[s] = true;
		//que�� ��� ������
		while(!que.isEmpty()) {
//			System.out.println();
			//que�� �����ֵ��� �����ִ°��� ��� ������ quae2�� �ִ´�.
			while(!que.isEmpty()) {
				int start = que.poll();
				ans = Math.max(ans,start);
//				System.out.print(start+ " ");
				for(int i=0;i<data[start].go.size();i++) {
					if(!visited[data[start].go.get(i)]) {
						int to = data[start].go.get(i);
						que2.add(to);
						visited[to] = true;
					}
				}
				if(!que2.isEmpty())ans = 0;
			}
//			System.out.println();
			
			//que2�� ��κ����� 
			//que2�� �����ִ¾ֵ� ��� que�� �ִ´�.
			
			while(!que2.isEmpty()) {
				int start = que2.poll();
				ans = Math.max(ans, start);
//				System.out.print(start+ " ");
				for(int i=0;i<data[start].go.size();i++) {
					if(!visited[data[start].go.get(i)]) {
						int to = data[start].go.get(i);
						que.add(to);
						visited[to] = true;
					}
				}
				if(!que.isEmpty())ans =0;
			}
		}
		
	}
	
	
}
