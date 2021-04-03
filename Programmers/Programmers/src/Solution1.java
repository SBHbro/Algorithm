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
        //�ζ� �迭�� ���� �¿� �ִ´�.
        for(int i = 0 ;i<6;i++) {
        	set.add(win_nums[i]);
        }
        
        int sameCount = 0;
        int zeroCount = 0;
        //win�迭�� ���鼭 0�̾ƴҰ�쿡 �¿� ������ ��ġ�� ���� ++
        for(int i = 0 ; i<6; i++) {
        	if(lottos[i] !=0) {
        		if(set.contains(lottos[i])) {
        			sameCount++;
        		}
        	}
        	else {
        		//0�ϰ���� ���� ����.
        		zeroCount++;
        	}
        }
        //�ְ� -> ���ݱ��� ��ġ�� ���� + 0�ǰ���
        //�־� -> ���ݱ��� ��ġ�� ����.
        int max = 6-(sameCount+zeroCount)+1!=7?6-(sameCount+zeroCount)+1:6;
        int min = 6-sameCount+1!=7?6-sameCount+1:6;
        answer = new int[] {max,min};
        return answer;
    }
}
