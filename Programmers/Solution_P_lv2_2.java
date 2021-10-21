package programmers;

import java.util.Arrays;

public class Solution_P_lv2_2 {

	public static int[] solution(int n) {
        int[] answer = {};
        int[][] data = new int[n][];
        
        //0~n-1번라인까지 배열 생성
        int max = 0;
        for(int i =0;i<n;i++) {
        	data[i] = new int[i+1];
        	max += i+1;
        }
        
        int dir = 0; // 방향
        int value = 2;
        int x=0,y=0;
        data[0][0] = 1;
        while(value<max+1) {
        	//아래로갈때
        	if(dir == 0) {
        		if(y+1<n&&data[y+1][x]==0) {
        			y++;
        			data[y][x] = value;
        			value++;
        		}
        		else
        			dir =1;
        	}
        	//오른쪽
        	else if(dir == 1) {
        		if(x+1<n && data[y][x+1]==0) {
        			x++;
        			data[y][x] = value;
        			value++;
        		}
        		else
        			dir=2;
        	}
        	//위
        	else if(dir ==2) {
        		if(y-1 <n && data[y-1][x-1] == 0 ) {
        			y--;
        			x--;
        			data[y][x] = value;
        			value++;
        		}
        		else
        			dir = 0;
        	}
        }
        
        answer = new int[max];
        int index = 0;
        
        for(int i = 0 ;i<n;i++) {
        	for(int j = 0 ;j<data[i].length;j++) {
        		answer[index] = data[i][j];
        		index++;
        	}
        }
        
        
        return answer;
    }
	
	public static void main(String[] args) {
		solution(6);
		
	}
}
