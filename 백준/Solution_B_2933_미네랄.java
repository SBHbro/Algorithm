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

public class Solution_B_2933_�̳׶� {

	//1.���� ����
	//2.Ŭ������ �����
	//3.�Ʒ��� ��������
	
	//1. ���ʿ��� ������ ��, �����ʿ��� ������ ��.
	//dx[i]�� ���ذ��� �װ��� �����̸� �μ���.
	//2. �μ������� ��,��,�� �� dfs�� ���� Ŭ�����͸� ���� �ʿ� �ִ´�
	//�� -> Ű = x  �� = ��Ʈ[](y�� ������ �켱) <Integer, List<Integer>>
	//3. Ű���� ��� ���� ��.get(0),Ű �� �Ʒ��� �� �������� Ȯ��
	// ��� ������� ��� for(Ű)for(��.size) ��-1,x �� ��,x
	
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
			//���ʿ��� ����
			if(i%2==1) {
//				System.out.println("���ʿ��� ����");
				ice = throwBar(ty,3);
			}
			//�����ʿ��� ����
			else {
//				System.out.println("�����ʿ��� ����");
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
//						System.out.println("������������ "+ j);
						cluster = new HashMap<Integer, List<Integer>>();
						checkCluster(new int[] {iceTy,iceTx});
//						if(i==6) {
//							out.write(iceTy+ " "+iceTx+"\n");
//							out.write(map[iceTy][iceTx] + "\n");
//							out.write(ice[0] + " " + ice[1] + "\n");
//							out.write(j+"�־ȶ�������? input "+ty+"\n");
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
//			System.out.println("�ܰ賡");
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
			//x�� ����ִ� ��ŭ
			for(Integer key : cluster.keySet()) {
				//x���� y�� ���������ָ� ã�´�.
				//�³׵��� ��� ������ �� �������
				//���� ��ü ���Ҹ� ���� ��ĭ�� ������.
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
//				System.out.println(y+" "+tx+" ��������");
				return new int[] {y,tx};
			}
		}
		return null;
	}
	
}
