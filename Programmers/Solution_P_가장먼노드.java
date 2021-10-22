package study_1022;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution_P_가장먼노드 {
	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(solution(n, edge));
	}
	
	public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        //list배열을 n개 만든다.
        //edge의 값을 list에 추가.
        //isVisit boolean 배열을 만든다.
        //que를 돌면서 depth와 개수를 체크한다.
        
        List<Integer>[] line = new ArrayList[n+1];
        
        for(int i = 0 ; i < n+1 ; i++) {
        	line[i] = new ArrayList<>();
        }
        
        
        for(int i = 0 ; i<edge.length;i++) {
        	line[edge[i][0]].add(edge[i][1]);
        	line[edge[i][1]].add(edge[i][0]);
        }
        
        boolean[] isVisit = new boolean[n+1];
        isVisit[1] = true;
        
        Queue<Integer> que1 = new LinkedList<Integer>();
        Queue<Integer> que2 = new LinkedList<Integer>();
        
        que1.add(1);
        
        while(!que1.isEmpty()) {
        	
        	while(!que1.isEmpty()) {
        		que2.add(que1.poll());
        	}
        	answer = que2.size();
        	
        	while(!que2.isEmpty()) {
        		int now = que2.poll();
        		for(int to : line[now]) {
        			if(!isVisit[to]) {
        				que1.add(to);
        				isVisit[to]=true;
        			}
        		}
        		
        	}
        }
        
        return answer;
    }
}
