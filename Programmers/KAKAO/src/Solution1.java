import java.util.Arrays;

public class Solution1 {
	
	public static void main(String[] args) {
		
		int[] gift_cards = {4,5,3,2,1};
//		int[] gift_cards = {5,4,5,4,5};
		int[] wants = {2,4,4,5,1};
//		int[] wants = {1,2,3,5,4};
		
		System.out.println(solution(gift_cards, wants));
	}
	static public int solution(int[] gift_cards, int[] wants) {
	        int answer = wants.length;
	        
	        //배열 둘다 정렬
	        Arrays.sort(gift_cards);
	        Arrays.sort(wants);
	        //while wants가 끝날대까지]
	        int pointerG=0;
	        int pointerW=0;
	        while(pointerW<wants.length&&pointerG<wants.length) {
	        	//둘다 왼쪽부터 시작
	        	//wants가 크면 gift_cards가 한칸오른쪽으로
	        	//gift_cards가 크면 wats가 한칸오른쪽으로
	        	//둘이 같으면 answer-1하고 둘다 오른쪽으로
	        	if(gift_cards[pointerG]<wants[pointerW]) {
	        		pointerG++;
	        		continue;
	        	}
	        	else if(gift_cards[pointerG]>wants[pointerW]) {
	        		pointerW++;
	        		continue;
	        	}
	        	else {
	        		pointerG++;
	        		pointerW++;
	        		answer--;
	        		continue;
	        	}
	        }
	        
	        return answer;
	    }
}
