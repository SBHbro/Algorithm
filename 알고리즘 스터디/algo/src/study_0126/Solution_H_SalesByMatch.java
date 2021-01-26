package study_0126;

public class Solution_H_SalesByMatch {
	 // Complete the sockMerchant function below.
    static int sockMerchant(int n, int[] ar) {
    	int answer = 0;
    	
    	int[] data = new int[101];
    	
    	for(int i = 0 ; i<ar.length;i++) {
    		data[ar[i]]++;
    		if(data[ar[i]]%2 == 0)
    			answer++;
    	}
    	
    	
    	return answer;
    }
    
    public static void main(String[] args) {
		System.out.println(sockMerchant(9,new int[] {10,20,20,10,10,30,50,10,20}));
	}

}
