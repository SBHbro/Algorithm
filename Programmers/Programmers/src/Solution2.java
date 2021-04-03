import java.util.Arrays;

public class Solution2 {
	
	
	public static void main(String[] args) {
//		int rows = 6;
//		int columns = 6;
		int rows = 3;
		int columns = 3;
//		int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
		System.out.println(Arrays.toString(solution(rows, columns, queries)));
	}
	
	static public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int[][] map = new int[rows][columns];
        
        int count = 1;
        for(int i = 0 ; i<rows;i++) {
        	for(int j = 0 ; j<columns; j++) {
        		map[i][j] = count++;
        	}
        }
        
        //queries의 길이만큼 포문
        for(int i = 0; i<queries.length;i++) {
        	answer[i] = rotate(queries[i][0]-1, queries[i][1]-1, queries[i][2]-1, queries[i][3]-1, map);
        }
        
        return answer;
    }
	
	static int[] dy = {0,1,0,-1};
	static int[] dx = {1,0,-1,0};
	static int rotate(int y1, int x1, int y2, int x2,int[][] map) {
		int dir = 0;
		int ty = y1;
		int tx = x1;
		int temp = map[y1][x1];
		int min = temp;
		while(dir!=4) {
			int y = ty + dy[dir];
			int x = tx + dx[dir];
			
			if(isSafe(y,x,y1,x1,y2,x2)) {
				int tp = map[y][x];
				map[y][x] = temp;
				temp = tp;
				ty = y;
				tx = x;
			}else {
				dir++;
			}
			min = Math.min(min, temp);
		}
		return min;
	}

	private static boolean isSafe(int y, int x, int y1, int x1, int y2, int x2) {
		return y1<=y&&y<=y2&&x1<=x&&x<=x2;
	}
}
