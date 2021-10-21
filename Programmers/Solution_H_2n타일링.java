package study_0306;

public class Solution_H_2n타일링 {

	public static void main(String[] args) {
		System.out.println(solution(9));
	}
	
	static public int solution(int n) {
        int[] dp = new int[60001];
        dp[1] = 1;
        dp[2] = 2;
        
        for(int i = 3;i<=n;i++) {
        	dp[i] = dp[i-2]%1000000007+dp[i-1]%1000000007;
        }
        
        if(n==1||n==2)
        	return dp[n];
        
        return dp[n]%1000000007;
    }
	
}
