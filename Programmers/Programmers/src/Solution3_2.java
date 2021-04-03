import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3_2 {
	
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"young", "john", "tod", "emily", "mary"};
//		String[] seller = {"sam", "emily", "jaimie", "edward"};
		int[] amount = {12, 4, 2, 5, 10};
//		int[] amount = {2, 3, 5, 4};
		
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}
	
	static class Data{
		String parent;
		int index;
		
		public Data(String parent, int index) {
			super();
			this.parent = parent;
			this.index = index;
		}
	}
	
	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, Data> dadangae = new HashMap<>();
        
        //�θ� ����
        for(int i = 0 ; i<referral.length;i++) {
        	String name = enroll[i];
        	String parent = referral[i];
        	
        	dadangae.put(name, new Data(parent,i));
        }
        dadangae.put("-", null);
        
        //�̸��� ������ ������
        //�θ� �ִ��� Ȯ�� �� �θ𿡰� 10���� �ְ� �������� ���� ������.
        //��=> �̸� : ������
        for(int i = 0 ; i<seller.length;i++) {
        	String name = seller[i];
        	int money = amount[i]*100;
        	
        	while(!name.equals("-")) {
        		//�� ������� ������(��õ���� ã�� �ڽ����� ���� ���ؾ���)
        		Data temp = dadangae.get(name);
        		
        		if(money/10<1) {
        			answer[temp.index]+=money;
        			break;
        		}
        		else {
        			answer[temp.index]+=money-(money/10);
        		}
        		
        		money = money/10;
        		name = temp.parent;
        	}
        	
        }
        
        return answer;
    }
}
