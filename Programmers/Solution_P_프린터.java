package study_1022;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution_P_프린터 {

	public static void main(String[] args) {
		int[] priorities = new int[] {2, 1, 3, 2};
//		int[] priorities = new int[] {1,1,9,1,1,1};
		int location = 2;
//		int location = 0;
		
		System.out.println(solution(priorities, location));
	}

	public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        Queue<int[]> que = new LinkedList<int[]>();
        Queue<int[]> que2 = new LinkedList<int[]>();
        
        for(int i = 0 ; i< priorities.length;i++) {
        	que.add(new int[] {priorities[i],i});
        }
        
        while(!que.isEmpty()) {
        	
        	int[] data = que.poll();
        	boolean check = false;
        	while(!que.isEmpty()) {
        		que2.add(que.poll());
        	}
        	
        	int[] temp = null;
        	while(!que2.isEmpty()) {
        		temp = que2.poll();
        		if(data[0]<temp[0]) {
        			check = true;
        		}
        		que.add(temp);
        	}
        	
        	if(check) {
        		if(temp!=null)
        			que.add(data);
        	}
        	else {
        		answer++;
        		if(data[1] == location) {
        			return answer;
        		}
        	}
        }
        
        return answer;
    }
}
