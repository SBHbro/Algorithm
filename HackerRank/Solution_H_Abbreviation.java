package study_0127;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Solution_H_Abbreviation {

	private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        int q = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int qItr = 0; qItr < q; qItr++) {
            String a = scanner.nextLine();

            String b = scanner.nextLine();

            String result = abbreviation(a, b);
            System.out.println(result);
        }


        scanner.close();
    }
//	
//	public static void main(String[] args) {
//		System.out.println(abbreviation("beFgH", "EFH"));
//		System.out.println(abbreviation("AfPZN", "APZNC"));
//		System.out.println(abbreviation("ssibal", "SSIBAL"));
//		System.out.println(abbreviation("daBcd", "ABC"));
//		System.out.println(abbreviation("AbcDE", "AFDE"));
//		System.out.println(abbreviation("AaaAaaBbB", "AAABB"));
//	}
//AaAaaBbB AAAB
//3 
//2 2
//3 1
	static String abbreviation(String a, String b) {
		
		//b시작부터 끝까지 간다
		//b의 자리에있는 애또는 걔의 다운을 만날까지 pointer올림
		//pointer가 a의 길이 끝에 다다르면 fail
		
		//대문자를 찾는다
		//없을경우 다시 돌아와서 소문자를 찾는다.
		
		int aPoint = 0 ;
		for(int i = 0 ; i<b.length();i++) {
			int temp = aPoint;
			boolean check = false;
			while(aPoint<a.length()&&!check) {
				if(b.charAt(i)==a.charAt(aPoint)) {
					check = true;
				}
				aPoint++;
			}
			if(check) continue;
			else {
				aPoint = temp;
				while(aPoint<a.length()&&!check) {
					if((b.charAt(i)+"").toLowerCase().equals(a.charAt(aPoint)+"")) {
						check = true;
					}
					aPoint++;
				}
			}
			
			if(!check) {
				return "NO";
			}
		}
//		System.out.println(aPoint);
//		System.out.println(a.length());
		for(int i = aPoint; i<a.length();i++) {
			if(a.charAt(i)<97) {
//				System.out.println("2");
				return "NO";
			}
			
		}
		
		return "YES";
		
		
		
//		//a 에 대한 소문자 대문자 알파벳 배열 생성
//		//b 에 대한 알파벳 배열 생성
//		//63 97
//		
//		
//		int[] aAlphaUp = new int[32];
//		int[] aAlphaDown = new int[32];
//		int[] bAlpha = new int[32];
//		
//		
//		for(int i = 0 ; i<a.length();i++) {
//			if(97<=a.charAt(i))
//				aAlphaDown[a.charAt(i)-97]++;
//			else {
//				aAlphaUp[a.charAt(i)-65]++;
//			}
//		}
//		
//		
//		for(int i = 0 ; i<b.length();i++) {
//			bAlpha[b.charAt(i)-65]++;
//		}
//		
//		System.out.println(Arrays.toString(aAlphaDown));
//		System.out.println(Arrays.toString(aAlphaUp));
//		System.out.println(Arrays.toString(bAlpha));
//		
//		for(int i = 0 ; i<32;i++) {
//			if(bAlpha[i]<aAlphaUp[i])
//				return "NO";
//			else {
//				if(bAlpha[i]>aAlphaUp[i]+aAlphaDown[i])
//					return "NO";
//			}
//		}
//		
//		
//		return "YES";
//		
		
		
//		for(int i = 0 ; i<b.length();i++) {
//			if(a.contains(b.charAt(i)+"")) {
//				a= a.replaceFirst((b.charAt(i)+""), "");
//			}
//			else if(a.contains((b.charAt(i)+"").toLowerCase())) {
//				a= a.replaceFirst((b.charAt(i)+"").toLowerCase(), "");
//			}
//			else
//				return "NO";
//		}
//		System.out.println(a);
//		for(int i = 0 ; i<a.length();i++) {
//			if(97<=a.charAt(i)) {
//				a = a.replaceFirst(a.charAt(i)+"", " ");
//			}
//		}
//		a = a.trim();
//		System.out.println(a);
//		System.out.println("length "+ a.length());
//		if(a.length()==0) {
//			return "YES";
//		}
//		
//		return "NO";
	}
}
