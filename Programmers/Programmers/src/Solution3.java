import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {
	
	public static void main(String[] args) {
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//		String[] seller = {"young", "john", "tod", "emily", "mary"};
		String[] seller = {"sam", "emily", "jaimie", "edward"};
//		int[] amount = {12, 4, 2, 5, 10};
		int[] amount = {2, 3, 5, 4};
		
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amount)));
	}
	
	static class Data{
		String parent;
		int money;
		
		public Data(String parent, int money) {
			super();
			this.parent = parent;
			this.money = money;
		}
	}
	
	static public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        
        Map<String, Data> dadangae = new HashMap<>();
        
        //�θ� ����
        for(int i = 0 ; i<referral.length;i++) {
        	String name = enroll[i];
        	String parent = referral[i];
        	
        	dadangae.put(name, new Data(parent,0));
        }
        dadangae.put("-", null);
        
        //�̸��� ������ ������
        //�θ� �ִ��� Ȯ�� �� �θ𿡰� 10���� �ְ� �������� ���� ������.
        //��=> �̸� : ������
        for(int i = 0 ; i<seller.length;i++) {
        	String name = seller[i];
        	int money = amount[i]*100;
        	
        	while(true) {
        		//�� ������� ������(��õ���� ã�� �ڽ����� ���� ���ؾ���)
        		Data temp = dadangae.get(name);
        		//��õ���� ������ (10%���� �ް� �ڱⰡ �θ����� ���� �����)
        		Data parent = dadangae.get(temp.parent);
        		
        		
        		if(money/10<1) {
        			temp.money+=money;
        			break;
        		}
        		else {
        			temp.money+=money-(money/10);
        		}
        		
        		if(parent==null) {
        			break;
        		}
        		money = money/10;
        		name = temp.parent;
        	}
        	
        }
        
        //enroll�� ������ ���� answer�迭�� ���� �ִ´�.
        for(int i = 0 ; i<enroll.length;i++) {
        	answer[i] = dadangae.get(enroll[i]).money;
        }
        
        return answer;
    }
}
