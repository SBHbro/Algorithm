package study_0907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_P_��ɰ��� {
	
	public static void main(String[] args) {
//		int[] progress = {93,30,55};
//		int[] speed = {1,30,5};
//		int[] progress = {95, 90, 99, 99, 80, 99};
//		int[] speed = {1, 1, 1, 1, 1, 1};
		int[] progress = {99,99};
		int[] speed = {2,1};
		
		System.out.println(Arrays.toString(solution(progress,speed)));
	}
	
	public static int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        //progress ������ ���� 
        //speed�� ����ŭ ���� �÷����鼭 �ø� Ƚ�� ����
        //���� 100 �Ѿ ��� �Ϸ� ���� ȸ�� +1 �ϰ� �������γѾ
        //���� �ø� ȸ����ŭ ���ǵ带 ���ؼ� progress�� ���غ��� 100�Ѿ��� �ٽ� �������� �Ѿ
        //���Ѿ������ �� �ʱ�ȭ, �Ϸ����ȸ�� �ʱ�ȭ
        List<Integer> answerList = new ArrayList<Integer>();
        
        int progressPointer = 0;
        int day =0;
        int answerTemp = 0;
        while(progressPointer <progresses.length) {
        	
        	while(progresses[progressPointer]<100) {
        		
        		progresses[progressPointer]+= speeds[progressPointer];
        		day++;
        	}
        	
        	answerTemp++;
        	progressPointer++;
        	while(progressPointer<progresses.length && progresses[progressPointer]+(speeds[progressPointer]*day)>=100){
        		answerTemp++;
        		progressPointer++;
        	}
        	
        	answerList.add(answerTemp);
        	if(progressPointer<progresses.length)
        		progresses[progressPointer]+=(speeds[progressPointer]*day);
        	answerTemp = 0;
        }
        
        answer = new int[answerList.size()];
        for(int i = 0 ; i<answer.length; i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
