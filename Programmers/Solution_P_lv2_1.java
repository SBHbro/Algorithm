package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_P_lv2_1 {
	 public static int[] solution(int n, String[] words) {
	        int[] answer = {};
	        
	        int pointerM = 1;
	        int step = 0;
	        List<String> lastWords = new ArrayList<String>();
	        char lastChar = words[0].charAt(0);
	        int[] stepP = new int[n+1];
	        
	        
	        while(true) {
	        	//검사할 글자의 첫자리와 이전 글자의 끝자리가 같아야 하고 이미 사용된 단어가 아니여아한다.
	        	if(lastChar == words[step].charAt(0) && !lastWords.contains(words[step])) {
	        		lastChar = words[step].charAt(words[step].length()-1);
	        		lastWords.add(words[step]);
	        		stepP[pointerM]++;
	        		step++;
	        		pointerM++;
	        		if(pointerM==n+1)pointerM=1;
	        	}
	        	else {
	        		stepP[pointerM]++;
	        		break;
	        	}
	        	if(step == words.length) {
	        		step =0;
	        		pointerM = 0;
	        		break;
	        	}
	        }
	        answer = new int[] {pointerM,stepP[pointerM]};
	        return answer;
	    }
	 
	 public static void main(String[] args) {
		int n = 5;
		String[] words = new String[] {"tank", "kick", "know", "wheel", "land", "dream",
			"mother", "robot", "tank"};
		String[] words2 = new String[] {"hello", "one", "even", "never", "now", "world", "draw"};
		
		
		System.out.println(Arrays.toString(solution(2,words2)));
	}
}
