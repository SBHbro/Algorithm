package study_0125;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Solution_H_Active_Traders {
	
	public static void main(String[] args) {
		
	}
	
	public static List<String> mostActive(List<String> customers) {
	    // Write your code here
		
		Map<String, Integer> data = new HashMap<String, Integer>();
		
		int customersSize = data.size();
		List<String> answer = new ArrayList<>();
		
		for(String i : customers) {
			if(!data.containsKey(i)) {
				data.put(i, 1);
			}
			else {
				data.put(i,data.get(i)+1);
			}
		}
		
		//5%넘으면 answer 리스트로 이동
		Set<Map.Entry<String, Integer>> entries = data.entrySet();
        
        for(Map.Entry<String, Integer> entry : entries) {

            if(5<=Double.valueOf(entry.getValue())/Double.valueOf(customersSize)*100) {
                System.out.println("들어옴");
                answer.add(entry.getKey());
            }
        }
		
		answer.sort(null);
		
		return answer;
	}
}
