package study_0126;

import java.util.Arrays;

public class Solution_H_MinimumSwap2 {
	
	public static void main(String[] args) {
		System.out.println(minimumSwaps(new int[] {2,3,4,1,5}));
		System.out.println(minimumSwaps(new int[] {1,3,5,2,4,6,7}));
	}
	
	static int minimumSwaps(int[] arr) {

		int answer= 0;
		
		for(int i = 0 ; i<arr.length;i++){
			while(arr[i]!=i+1) {
				swap(arr,arr[i]-1,i);
				answer++;
			}
		}
		return answer;
    }
	
	static void swap(int[] arr, int a , int b) {
		int temp = arr[b];
		arr[b] = arr[a];
		arr[a] = temp;
	}
	
}
