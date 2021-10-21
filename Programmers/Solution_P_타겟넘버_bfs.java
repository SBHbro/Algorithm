package study_1021;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_P_타겟넘버_bfs {
	
	public static void main(String[] args) {
		int[] numbers = new int[] {1,1,1,1,1};
		int target = 3;
		
		System.out.println(solution(numbers, target));
	}
	
	public static int solution(int[] numbers, int target) {
        return dfs(numbers, target, 0, 0);
    }
	
	public static int dfs(int[] numbers, int target, int depth, int val) {
		
		if(depth == numbers.length) {
			if(val == target) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		return dfs(numbers, target, depth+1, val+numbers[depth]) + dfs(numbers, target, depth+1, val-numbers[depth]);
	}
}
