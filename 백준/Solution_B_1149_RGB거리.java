package study_0203;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_1149_RGB거리 {

	static int[][] data;
	static int N;
	static int[][] dp;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(in.readLine());
		
		data = new int[N][3];
		dp = new int[N][3];
		
		for(int i = 0 ; i<N;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			data[i][0] = Integer.parseInt(st.nextToken());
			data[i][1] = Integer.parseInt(st.nextToken());
			data[i][2] = Integer.parseInt(st.nextToken());
			dp[i][0] = Integer.MAX_VALUE;
			dp[i][1] = Integer.MAX_VALUE;
			dp[i][2] = Integer.MAX_VALUE;
		}
		
		dp[0][0] = data[0][0];
		dp[0][1] = data[0][1];
		dp[0][2] = data[0][2];
		
		
		bfs();
		
		System.out.println(Math.min(dp[N-1][0], Math.min(dp[N-1][1], dp[N-1][2])));
	}

	private static void bfs() {
		
		//어디에서 왔는지
		Queue<Integer> que = new LinkedList<Integer>();
		Queue<Integer> que2 = new LinkedList<Integer>();
		
		que.add(0);
		que.add(1);
		que.add(2);
		
		//몇번째 집인지
		int depth = 1;
		
		//와일 큐빌때까지
		while(!que.isEmpty()&&depth<N) {
			
			while(!que.isEmpty()) {
				que2.add(que.poll());
			}
			
			
			while(!que2.isEmpty()) {
				
				int from = que2.poll();
				
				for(int i = 0;i <3;i++) {
					if(from == i)
						continue;
					
					int now = dp[depth-1][from] + data[depth][i];
					//r색칠한곳에서 오지 않았고 전에있던곳에서 여기오는 색칠의 비용이 원래보다 작으면 바꾸고 다음으로간다.
					if(now<dp[depth][i]) {
						dp[depth][i] = now;
						que.add(i);
					}
				}
			}
			depth++;
		}
		
		//큐에있는거 다 큐2로 옮긴다
		//와일 큐2빌때까지
		//하나씩 꺼낸다
		//꺼낸애를 온곳과 비교해서 갈 수 있는곳을 이프문으로 간다음
		//거기의 dp값이 0이면 그냥 넣고
		//0이 아닌데 나보다 값이 크면 넣고 큐1에 넣는다.
		
	}
	
	
}
