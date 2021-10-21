package study_1021;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_P_Å¸°Ù³Ñ¹ö_dfs2 {
	
	public static void main(String[] args) {
		int[] numbers = new int[] {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        int answer = 0;
        
        int depth = 0;
        
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();
        
        que1.add(0);
        
        while(depth < numbers.length) {

        	while(!que1.isEmpty()) {
        		que2.add(que1.poll());
        	}
        	
        	while(!que2.isEmpty()) {
        		int temp = que2.poll();
        		que1.add(temp + numbers[depth]);
        		que1.add(temp + (numbers[depth] * -1));
        	}
        	
        	depth++;
        	
        }
        
        while(!que1.isEmpty()) {
        	if(que1.poll() == target) {
        		answer++;
        	}
        }
        
        return answer;
    }
}
