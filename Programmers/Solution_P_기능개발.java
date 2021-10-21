package study_0907;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_P_기능개발 {
	
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
        //progress 포인터 생성 
        //speed의 값만큼 값을 올려가면서 올린 횟수 저장
        //값이 100 넘어갈 경우 하루 배포 회수 +1 하고 다음으로넘어감
        //값을 올린 회수만큼 스피드를 곱해서 progress에 더해보고 100넘어갈경우 다시 다음으로 넘어감
        //못넘었을경우 값 초기화, 하루배포회수 초기화
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
