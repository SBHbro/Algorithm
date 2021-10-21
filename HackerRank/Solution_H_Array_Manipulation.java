package study_0205;

public class Solution_H_Array_Manipulation {

	// Complete the arrayManipulation function below.
    static long arrayManipulation(int n, int[][] queries) {

    	long answer = 0;
    	
    	int m = queries.length;
    	
    	long[][] data = new long[m][n];
    	for(int i = 0 ; i<m;i++) {
    		data[i][queries[i][0]-1] += queries[i][2];
    		if(queries[i][1]<n)
    			data[i][queries[i][1]] -=queries[i][2];
    	}
    	
    	long temp = 0;
    	for(int i = 0 ; i<n;i++) {
    		temp += data[m-1][i];
    		answer = Math.max(answer, temp);
    	}
    	
    	return answer;
    	
    }
	
}
