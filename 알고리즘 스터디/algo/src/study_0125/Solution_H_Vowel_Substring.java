package study_0125;

public class Solution_H_Vowel_Substring {
	/*
     * Complete the 'findSubstring' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */
	
	public static void main(String[] args) {
//		System.out.println(findSubstring("azerdii", 5));
		System.out.println(findSubstring("qwdftr", 5));
	}
	
	public static boolean checkIn(char data) {
		
		if(data == 'a'||data == 'e'||data == 'i'||data == 'o'||data == 'u') {
			return true;
		}
		
		return false;
	}
	
    public static String findSubstring(String s, int k) {
    // Write your code here
    	int value = 0;
    	int max = 0;
    	int answer = 0;
    	//0번부터 k 번까지 체크
    	for(int i = 0 ; i<k;i++) {
    		if(checkIn(s.charAt(i))){
    			value++;
    		}
    	}
    	
    	max = value;
    	
    	//k번부터 s.length - k= 까지 체크
    	for(int i = 1;i<=s.length()-k;i++) {
    		if(checkIn(s.charAt(i-1))) {
    			value--;
    		}
    		
    		if(checkIn(s.charAt(i+k-1))) {
    			value++;
    		}
    		
    		if(max<value) {
    			max =value;
    			answer=i;
    		}
//    		System.out.println(i+ " "+ value);
    	}
    	
//    	System.out.println(value);
//    	System.out.println(max);
    	if(max == 0)
    		return "Not found!";
    	
    	return s.substring(answer,answer+k);
    }

}
