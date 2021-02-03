package study_1201;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Solution_B_19238_½ºÅ¸Æ®ÅÃ½Ã {

	static int N,M,F; //¸ÊÅ©±â, ½Â°´¼ö, ¿¬·á
	static int[][] map; //¸Ê
	static int ay,ax; //ÅÃ½ÃÀ§Ä¡
	static ArrayList<Node> start = new ArrayList<>();
	static ArrayList<Node> end = new ArrayList<>();
	
	
	public static class Node{
		public Node(int y, int x, int d) {
			this.y = y;
			this.x = x;
			this.distance = d;
		}
		int y;
		int x;
		int distance;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		F = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];
		//¸Ê Á¤º¸ ÀÔ·Â
		for(int i = 0 ; i<N;i++) {
			st = new StringTokenizer(in.readLine());
			for(int j =0;j<N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(in.readLine());
		ay = Integer.parseInt(st.nextToken());
		ax = Integer.parseInt(st.nextToken());
		
		for(int i =0;i<M;i++) {
			st = new StringTokenizer(in.readLine());
			start.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0));
			end.add(new Node(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0));
		}
		
		for(int i = 0 ; i<M;i++) {
			System.out.println(start.get(i).y);
		}
		
	}
}
