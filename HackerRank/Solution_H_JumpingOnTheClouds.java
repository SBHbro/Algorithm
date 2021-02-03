package study_0126;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_H_JumpingOnTheClouds {
	
	public static void main(String[] args) {
		System.out.println(jumpingOnClouds(new int[] {0,0,1,0,0,1,0}));
	}
	
	static int jumpingOnClouds(int[] c) {
		int answer = 0;
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(c.length-1);
		
		while(!que.isEmpty()) {
			Queue<Integer> que2 = new LinkedList<>();
			while(!que.isEmpty()) {
				que2.add(que.poll());
			}
			
			while(!que2.isEmpty()) {
				int temp = que2.poll();
				
				if(temp == 0)return answer;
				
				if(0<=temp-1&&c[temp-1]!=1) {
					que.add(temp-1);
				}
				
				if(0<=temp-2&&c[temp-2]!=1) {
					que.add(temp-2);
				}
				
			}
			answer++;
		}
		
		
		return -1;

    }
	
}
