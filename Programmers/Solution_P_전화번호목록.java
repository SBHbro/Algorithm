package study_1022;

import java.util.HashSet;

public class Solution_P_전화번호목록 {
	public static void main(String[] args) {
		
		String a = "abcde";
		
//		String[] phone_book = {"119", "97674223", "1195524421"};
		String[] phone_book = {"123","456","789"};
		
//		System.out.println(a.substring(0,5));
		System.out.println(solution(phone_book));
		
	}
	
	public static boolean solution(String[] phone_book) {
        boolean answer = true;
        
        HashSet<Integer> hashSet = new HashSet<>();
        
        for(String input : phone_book) {
        	hashSet.add(input.hashCode());
        }
        
        for(String input : phone_book) {
        	for(int i = 1 ; i<input.length();i++) {
        		String temp = input.substring(0,i);
        		if(hashSet.contains(temp.hashCode())) {
        			return false;
        		}
        	}
        }
        
        return answer;
    }
}
