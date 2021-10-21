package study_1210;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_20055_컨베이어벨트위의로봇_pointer {

	static int N, K;
	static int answer = 1;
	static int start,end;
	static int[] map;
	static boolean[] isRobot;
	static Queue<Integer> que = new LinkedList<>();
	static Queue<Integer> que2 = new LinkedList<>();

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		int max = 2 * N;
		map = new int[max+1];
		isRobot = new boolean[max+1];
		
		start = 1;
		end = N;
		

		st = new StringTokenizer(in.readLine());
		for (int i = 1; i <= max; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}

		int count = 0;
		while (true) {
			
			// 돌리기
			start--;
			end--;
			if(start == 0 )start = max;
			if(end == 0 )end = max;
			
			// 로봇 이동
			while(!que2.isEmpty()) {
				que.add(que2.poll());
			}
			while(!que.isEmpty()) {
				int temp = que.poll();
				if(temp == end) {
					isRobot[temp]=false;
					continue;
				}
				int temp2 = temp+1;
				if(temp2>max)temp2-=max;
				if(!isRobot[temp2]&&0<map[temp2]) {
					isRobot[temp2]= true;
					map[temp2]--;
					isRobot[temp] = false;
					
					if(map[temp2]==0) {
						count++;
					}
					
					if(temp2==end) {
						isRobot[temp2]=false;
					}
					else {
						que2.add(temp2);
					}
					
				}
				else {
					que2.add(temp);
				}
			}
			
			// 로봇 올리기
			if(!isRobot[start]&&0<map[start]) {
				map[start]--;
				isRobot[start]=true;
				que2.add(start);
				if(map[start] == 0)
					count++;
			}
			if (count >= K)
				break;

			answer++;
		}
		System.out.println(answer);

	}
}
