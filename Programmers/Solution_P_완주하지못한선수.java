package study_0906;

import java.util.HashMap;
import java.util.Map;

public class Solution_P_�����������Ѽ��� {
	
	
	public static void main(String[] args) {
//		String[] participant = {"leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
//		String[] participant = {"marina", "josipa", "nikola", "vinko", "filipa"};
//		String[] completion = {"josipa", "filipa", "marina", "nikola"};
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
		
		System.out.println(solution(participant, completion));
	}

	public static String solution(String[] participant, String[] completion) {
        String answer = "";
        
        //completion�� hashmap�� �ִ´�. �̹� ������� 2�� �Ѵ�.
        //participant�� �ִ��� Ȯ���Ѵ�. ���� 2��� 1�� �����ϰ� 1�̶�� �����Ѵ�.
        //������� answer�� �ְ� return �Ѵ�.
        
        HashMap<String, Integer> map = new HashMap<>();
        
        for(String a : participant) {
        	
        	if(map.get(a)==null) {
        		map.put(a, 1);
        	}
        	else {
        		map.put(a,map.get(a)+1);
        	}
        	
        }
        
        int temp = 0;
        for(String a : completion) {
        	
        	temp = map.get(a)-1;
        	map.put(a, temp);
        }
        
        for(String a : map.keySet()) {
        	if(map.get(a)==1) {
        		answer = a;
        		break;
        	}
        }
        
        
        return answer;
    }
	
}
