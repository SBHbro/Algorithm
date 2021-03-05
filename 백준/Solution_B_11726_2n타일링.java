package study_0306;

import java.util.Scanner;

public class Solution_B_11726_2n≈∏¿œ∏µ {

	private static Scanner sc;

	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3;i<=N;i++) {
        	dp[i] = dp[i-2]%10007+dp[i-1]%10007;
        }
        
        if(N==1||N==2) {
        	System.out.println(dp[N]);
        	return;
        }
        
        System.out.println(dp[N]%10007);
	}
	
}
