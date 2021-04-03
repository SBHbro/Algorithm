import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution3 {
	
	public static void main(String[] args) {
		
		int n = 6;
//		int[] passenger = {1,1,1,1,1,1};
		int[] passenger = {2,1,2,2};
//		int[][] train = {{1,2},{1,3},{1,4},{3,5},{3,6}};
		int[][] train = {{1,2},{1,3},{2,4}};
		
		System.out.println(Arrays.toString(solution(n, passenger, train)));
		
	}
	
	
	static public int[] solution(int n, int[] passenger, int[][] train) {
        int[] answer = {0,Integer.MIN_VALUE};
        
        boolean[] isVisit = new boolean[n+1];
        Queue<int[]> que = new LinkedList<int[]>();
        Queue<int[]> que2 = new LinkedList<int[]>();
        List<Integer>[] data = new ArrayList[n+1];
        for(int i = 0 ;i<train.length;i++) {
        	int from = train[i][0];
        	int to = train[i][1];
        	if(data[from]==null) {
        		data[from]=new ArrayList<>();
        	}
        	if(data[to]==null) {
        		data[to]=new ArrayList<>();
        	}
        	
        	data[from].add(to);
        	data[to].add(from);
        }
        
        //1번을 큐에 넣는다.
        //1번을 꺼내고 1번을 방문 표시 한 뒤 1번이 갈 수 있는 애들을 모두 찾아서 다시 큐에넣으면서 가장 큰 값을 찾는다.
        //끝날때까지 반복
        //que= node, 지금까지의 값
        
        que.add(new int[] {1,passenger[0]});
        
        while(!que.isEmpty()) {
        	while(!que.isEmpty()) {
        		que2.add(que.poll());
        	}
        	while(!que2.isEmpty()) {
        		int[] temp = que2.poll();
        		int node = temp[0];
        		int man = temp[1];
        		isVisit[node] = true;
        		
        		for(int to : data[node]) {
        			if(!isVisit[to]) {
        				int tempMan = man + passenger[to-1];
        				if(answer[1]<=tempMan) {
        					if(answer[1]==tempMan)
        						answer[0] = Math.max(answer[0], to);
        					else
        						answer[0] = to;
        					answer[1] = tempMan;
        				}
        				que.add(new int[] {to,tempMan});
        			}
        		}
        		
        	}
        	
        }
        
        return answer;
    }
}
