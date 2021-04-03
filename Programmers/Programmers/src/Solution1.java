import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution1 {
    
	
	public static void main(String[] args) {
		
		//int[] lottos = {44, 1, 0, 0, 31, 25};
		//int[] lottos = {0, 0, 0, 0, 25, 15};
		int[] lottos = {39, 12, 21, 41, 12, 35};
		//int[] win_nums = {31, 10, 45, 1, 6, 19};
		int[] win_nums = {38, 19, 20, 40, 15, 25};
		
		System.out.println(Arrays.toString(solution(lottos, win_nums)));
	}
	
	static public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[] {};
        
        Set<Integer> set = new HashSet<>();
        //로또 배열의 값을 셋에 넣는다.
        for(int i = 0 ;i<6;i++) {
        	set.add(win_nums[i]);
        }
        
        int sameCount = 0;
        int zeroCount = 0;
        //win배열을 돌면서 0이아닐경우에 셋에 있으면 겹치는 숫자 ++
        for(int i = 0 ; i<6; i++) {
        	if(lottos[i] !=0) {
        		if(set.contains(lottos[i])) {
        			sameCount++;
        		}
        	}
        	else {
        		//0일경우의 값을 센다.
        		zeroCount++;
        	}
        }
        //최고 -> 지금까지 겹치는 숫자 + 0의개수
        //최악 -> 지금까지 겹치는 숫자.
        int max = 6-(sameCount+zeroCount)+1!=7?6-(sameCount+zeroCount)+1:6;
        int min = 6-sameCount+1!=7?6-sameCount+1:6;
        answer = new int[] {max,min};
        return answer;
    }
}
