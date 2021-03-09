package study_0309;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution_B_2933_미네랄 {

	//1.얼음 깨기
	//2.클러스터 재생성
	//3.아래로 떨어지기
	
	//1. 왼쪽에서 던졌을 때, 오른쪽에서 던졌을 때.
	//dx[i]를 더해가며 그곳이 얼음이면 부순다.
	//2. 부서진곳의 상,우,좌 를 dfs로 돌며 클러스터를 만들어서 맵에 넣는다
	//맵 -> 키 = x  값 = 인트[](y가 낮은게 우선) <Integer, List<Integer>>
	//3. 키값을 모두 돌며 값.get(0),키 의 아래가 빈 공간인지 확인
	// 모두 빈공간일 경우 for(키)for(값.size) 값-1,x 는 값,x
	
	static int R,C;
	static char[][] map;
	static int N;
	static int[] dy = {-1,1,0,0};
	static int[] dx = {0,0,-1,1};
	static Map<Integer, List<Integer>> cluster;
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(in.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		
		map = new char[R][C];
		
		for(int i = 0 ;i<R;i++) {
			map[i] = in.readLine().toCharArray();
		}
		
		N = Integer.parseInt(in.readLine());
		st = new StringTokenizer(in.readLine());
		for(int i = 1 ; i<=N;i++) {
			int ty = R-Integer.parseInt(st.nextToken());
			int[] ice;
			//왼쪽에서 던짐
			if(i%2==1) {
//				System.out.println("왼쪽에서 던짐");
				ice = throwBar(ty,3);
			}
			//오른쪽에서 던짐
			else {
//				System.out.println("오른쪽에서 던짐");
				ice = throwBar(ty,2);
			}
			if(ice != null){
				for(int j = 0 ;j<4;j++) {
//					if(j == 1) {
//						continue;
//					}
					int iceTy = ice[0]+dy[j];
					int iceTx = ice[1]+dx[j];
					if(isSafe(iceTy,iceTx)&&map[iceTy][iceTx]=='x') {
//						System.out.println("얼음조각만남 "+ j);
						cluster = new HashMap<Integer, List<Integer>>();
						checkCluster(new int[] {iceTy,iceTx});
//						if(i==6) {
//							out.write(iceTy+ " "+iceTx+"\n");
//							out.write(map[iceTy][iceTx] + "\n");
//							out.write(ice[0] + " " + ice[1] + "\n");
//							out.write(j+"왜안떨어지지? input "+ty+"\n");
							for(Integer a : cluster.keySet()) {
								Collections.sort(cluster.get(a),Comparator.reverseOrder());
//								out.write(a + " " + cluster.get(a)+"\n");
							}
//						}
						downCluster();
					}
				}
			}
//			System.out.println();
//			System.out.println("단계끝");
		}
		
		for(char[] a : map) {
			for(char b : a) {
				out.write(b);
			}
			out.write("\n");
		}
		
		out.close();
		
		
	}

	private static void downCluster() {
		while(true) {
			//x가 들어있는 만큼
			for(Integer key : cluster.keySet()) {
				//x에서 y가 가장작은애를 찾는다.
				//걔네들이 모두 내려갈 수 있을경우
				//맵의 전체 원소를 돌며 한칸씩 내린다.
				int top=cluster.get(key).get(cluster.get(key).size()-1);
				int bottom=cluster.get(key).get(0);
//				Collections.sort(cluster.get(key),Comparator.reverseOrder());
//				System.out.println(key+ " "+cluster.get(key).get(0)+" " +map[key][cluster.get(key).get(0)]);
				if(!isSafe(bottom+1,key)||map[bottom+1][key]!='.') {
//					System.out.println("?");
					return;
				}
				if(map[top+1][key]=='x') {
					if(!cluster.get(key).contains(top+1))
						return;
				}
			}
			
			moveBelow();
		}
	}

	private static void moveBelow() {
		for(Integer key : cluster.keySet()) {
			for(int i = 0 ;i<cluster.get(key).size();i++) {
				int ty = cluster.get(key).get(i);
				map[ty+1][key] =map[ty][key];
				map[ty][key] = '.';
				cluster.get(key).set(i,ty+1);
			}
		}
	}

	private static boolean isSafe(int y, int x) {
		return 0<=y&&y<R&&0<=x&&x<C;
	}

	private static void checkCluster(int[] ice) {
		if(!cluster.containsKey(ice[1]))
			cluster.put(ice[1], new ArrayList<Integer>());
		if(cluster.get(ice[1]).contains(ice[0]))
			return;
		
		cluster.get(ice[1]).add(ice[0]);
		
		for(int i = 0 ; i<4;i++) {
			int[] temp = new int[2];
			temp[0] = ice[0]+dy[i];
			temp[1] = ice[1]+dx[i];
//			System.out.println(temp[0]+ " "+ temp[1]);
//			System.out.println(map[temp[0]][temp[1]]);
			if(isSafe(temp[0],temp[1])&&map[temp[0]][temp[1]]=='x') {
				checkCluster(temp);
			}
		}
		
	}

	private static int[] throwBar(int y, int direction) {
		int tx = direction == 3?-1:C;
		for(int i = 0 ; i<C;i++) {
			tx += dx[direction];
			if(map[y][tx] == 'x') {
				map[y][tx] = '.';
//				System.out.println(y+" "+tx+" 얼음만남");
				return new int[] {y,tx};
			}
		}
		return null;
	}
	
}
