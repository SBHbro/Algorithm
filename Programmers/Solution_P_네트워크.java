package study_1230;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_P_네트워크 {
	
	public static void main(String[] args) {
//		int[][] input = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int[][] input = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(3,input));
	}
	
	public static int solution(int n, int[][] computers) {
		int answer = 0;
		boolean[] isVisit = new boolean[n];
		Queue<Integer> que = new LinkedList<Integer>();
		
		for (int i = 0; i < n; i++) {
			if (!isVisit[i])
				que.add(i);
			else
				continue;

			while (!que.isEmpty()) {
				int now = que.poll();
				isVisit[now] = true;
				for (int j = 0; j < n; j++) {
					if (now == j)
						continue;
					if (computers[now][j] == 1 && !isVisit[j])
						que.add(j);
				}

			}

			answer++;
		}
		return answer;
	}

}
