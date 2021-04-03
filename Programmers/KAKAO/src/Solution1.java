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
	        
	        //�迭 �Ѵ� ����
	        Arrays.sort(gift_cards);
	        Arrays.sort(wants);
	        //while wants�� ���������]
	        int pointerG=0;
	        int pointerW=0;
	        while(pointerW<wants.length&&pointerG<wants.length) {
	        	//�Ѵ� ���ʺ��� ����
	        	//wants�� ũ�� gift_cards�� ��ĭ����������
	        	//gift_cards�� ũ�� wats�� ��ĭ����������
	        	//���� ������ answer-1�ϰ� �Ѵ� ����������
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
