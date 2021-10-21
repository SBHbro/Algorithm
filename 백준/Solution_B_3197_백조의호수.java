package study_0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_B_3197_백조의호수 {

	
	//물인걸 모두 큐에 넣는다
	//와일 큐가 빌때까지 로 돌린다
	//물인애들을 큐에서 꺼내서 상하좌우 검색해서 얼음이 있으면 그걸 큐에 넣고 그 좌표를 물로 바꾼다.
	//백조의 좌표를 가지고 만날 수 있는지 확인한다
	//둘에서 시작해서 만난다면 반복문을 멈추고 하나라도 못만나고 끝나면 반복문을 멈춘다
	//반복한다
	
	static int R,C;
	static char[][] map;
	static int[][] mapInt;
	static Queue<int[]> water = new LinkedList<int[]>();
	static int ly = -1 , lx = -1, ly2 = -1, lx2=-1;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static int answer;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		mapInt = new int[R][C];
		
		for(int i = 0; i<R;i++) {
			String input = in.readLine();
			for(int j = 0;j<C;j++) {
				map[i][j] = input.charAt(j);
				if(map[i][j] == '.') {
					water.add(new int[] {i,j});
				}
				else if(map[i][j] == 'L') {
					ly = i;
					lx = j;
					water.add(new int[] {i,j});
				}
				else {
					mapInt[i][j] = Integer.MAX_VALUE;
				}
			}
		}
		
		Queue<int[]> water2 = new LinkedList<>();
		int day = 1;
		while(!water.isEmpty()) {
			
			while(!water.isEmpty()) {
				water2.add(water.poll());
			}
			while(!water2.isEmpty()) {
				int[] waterTemp = water2.poll();
				for(int i = 0 ; i<4;i++) {
					int ty = waterTemp[0]+dy[i];
					int tx = waterTemp[1]+dx[i];
					if(isSafe(ty,tx)&&map[ty][tx]=='X') {
						map[ty][tx] = '.';
						mapInt[ty][tx] = day;
						water.add(new int[] {ty,tx});
					}
				}
			}
			day++;
			
		}
		binarySearch(0,(day-1)/2,day-1);
		
		System.out.println(answer);
		
	}


	private static void binarySearch(int start, int middle, int end) {
		//만날경우
		if(isMeet(middle)) {
			if(middle-1<start)
				return;
			binarySearch(start,(start+middle-1)/2,middle-1);
		}
		//못만날경우
		else {
			if(end<middle+1)
				return;
			binarySearch(middle+1,(middle+1+end)/2,end);
		}
		
	}


	private static boolean isMeet(int middle) {
		mapInt[ly][lx] = middle+1;
		boolean[][] visited = new boolean[R][C];
		Queue<int[]> birds = new LinkedList<>();
		birds.add(new int[] {ly,lx});
		
		while(!birds.isEmpty()) {
			
			int[] tempBirds = birds.poll();
			for(int i = 0 ; i<4;i++) {
				int ty = tempBirds[0]+dy[i];
				int tx = tempBirds[1]+dx[i];
				
				if(isSafe(ty,tx)&&mapInt[ty][tx]<=middle&&!visited[ty][tx]) {
					if(map[ty][tx]=='L') {
						answer = middle;
						return true;
					}
					visited[ty][tx] = true;
					birds.add(new int[] {ty,tx});
				}
			}
	
		}
		
		return false;
	}

	private static boolean isSafe(int y, int x) {
		return 0<=y&&y<R&&0<=x&&x<C;
	}
	
}
