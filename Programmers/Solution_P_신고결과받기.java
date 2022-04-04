package study_220404;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution_P_신고결과받기 {
	
	public static void main(String[] args) {
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		String[] idList = {"muzi", "frodo", "apeach", "neo"};
		
		System.out.println(Arrays.toString(solution(idList,report,2)));
	}
	
	public static class User{
		int mailCount;
		Set<String> reportedUserNames;
		
		User(){
			mailCount = 0;
			reportedUserNames = new HashSet<>();
		}
	}
	
	
	public static int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        User[] users = new User[id_list.length];
        Map<String, Integer> userIndex = new HashMap<>();
        
        for(int i = 0 ; i<id_list.length;i++) {
        	userIndex.put(id_list[i], i);
        	users[i] = new User();
        }
        
        for(int i = 0 ; i<report.length;i++)
        {
        	StringTokenizer st = new StringTokenizer(report[i]);
        	String reportFrom = st.nextToken();
        	String reportTo = st.nextToken();
        	
        	users[userIndex.get(reportTo)].reportedUserNames.add(reportFrom);
        }
        
        for(int i = 0 ; i<users.length;i++) {
        	if(k <= users[i].reportedUserNames.size()) {
        		for(String reportFrom : users[i].reportedUserNames) {
        			users[userIndex.get(reportFrom)].mailCount++;
        		}
        	}
        }
        
        for(int i = 0; i<users.length;i++) {
        	answer[i] = users[i].mailCount;
        }
        
        return answer;
    }
}
