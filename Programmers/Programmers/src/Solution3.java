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
        
        //부모 연결
        for(int i = 0 ; i<referral.length;i++) {
        	String name = enroll[i];
        	String parent = referral[i];
        	
        	dadangae.put(name, new Data(parent,0));
        }
        dadangae.put("-", null);
        
        //이름과 수익이 들어오면
        //부모가 있는지 확인 후 부모에게 10프로 주고 나머지는 내가 가진다.
        //맵=> 이름 : 데이터
        for(int i = 0 ; i<seller.length;i++) {
        	String name = seller[i];
        	int money = amount[i]*100;
        	
        	while(true) {
        		//돈 번사람의 데이터(추천인을 찾고 자신한테 돈을 더해야함)
        		Data temp = dadangae.get(name);
        		//추천인의 데이터 (10%돈을 받고 자기가 부모한테 돈을 줘야함)
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
        
        //enroll의 순서를 따라 answer배열에 값을 넣는다.
        for(int i = 0 ; i<enroll.length;i++) {
        	answer[i] = dadangae.get(enroll[i]).money;
        }
        
        return answer;
    }
}
