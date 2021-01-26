package study_0126;

import java.util.Arrays;

public class Solution_H_RepeatedString {
	public static void main(String[] args) {
//		System.out.println(repeatedString("ab", 1000000000001L));
//		System.out.println(repeatedString("abcda", 52));
		System.out.println(repeatedString("epsxyyflvrrrxzvnoenvpegvuonodjoxfwdmcvwctmekpsnamchznsoxaklzjgrqruyzavshfbmuhdwwmpbkwcuomqhiyvuztwvq", 549382313570L));
	}
	
	static long repeatedString(String s, long n) {
		long answer = 0;
		long temp = 0;
		long[] temp2 = new long[s.length()];
		for(int i = 0 ; i<s.length();i++) {
			if(s.charAt(i)=='a') {
				temp++;
			}
			temp2[i] = temp;
		}
		
		answer += temp*(n/s.length());
		long temp3 = n%s.length();
		
		if(1<=temp3) {
			temp3--;
			answer+=temp2[(int) temp3];
		}
		
		return answer;
    }
	
}
