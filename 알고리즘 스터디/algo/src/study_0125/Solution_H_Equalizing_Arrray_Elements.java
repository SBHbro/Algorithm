package study_0125;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class Solution_H_Equalizing_Arrray_Elements {

	public static void main(String[] args) throws NumberFormatException, IOException {
		List<Integer> arr = new ArrayList<>();
//		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
//		
//		int temp = Integer.parseInt(in.readLine());
//		
//		for(int i = 0 ; i<temp;i++) {
//			arr.add(Integer.parseInt(in.readLine()));
//		}
//		
//		int threshold = Integer.parseInt(in.readLine());
//		int d = Integer.parseInt(in.readLine());
//		arr.add(4);
//		arr.add(1);
//		arr.add(2);
//		arr.add(3);
//		arr.add(4);
		arr.add(64);
		arr.add(30);
		arr.add(25);
		arr.add(33);
		int threshold =2;
		int d = 2;
		System.out.println(minOperations(arr, threshold, d));
	}

	static int answer;
	static int[] data;
	static int maxData;
	static SortedMap<Integer, Integer> map = new TreeMap<Integer, Integer>((s1,s2) -> s2-s1);
	public static int minOperations(List<Integer> arr, int threshold, int d) {
		
//		arr.sort(null);
		maxData = arr.get(arr.size()-1);
		
		data = new int[20001];
		
		for(int i : arr) {
//			data[i]++;
//			answer = Math.max(data[i], answer);
//			maxData = Math.max(i, maxData);
			if(!map.containsKey(i))
				map.put(i, 1);
			else {
				map.put(i, map.get(i)+1);
				answer = Math.max(map.get(i), answer);
			}
		}
		
//		map.keySet().forEach(key ->{
//			System.out.println(key);
//		});
		
		
		
		if(answer>threshold)
			answer =0;
		else {
			answer = Integer.MAX_VALUE;
			dfs(0,threshold,d,0);
		}
//		System.out.println(maxData);
		System.out.println(map.get(4)!=null&&map.get(4)>0);
		System.out.println(map.get(4)!=null&&map.get(4)>0);
		//같은 값이 들어오지 않는다면
		
		
		return answer;
	}

	private static void dfs(int depth, int threshold, int d,int k) {
		
//		System.out.println(k);
		
		if(answer<=depth)
			return;
		
		if(threshold==k) {
			answer = Math.min(answer, depth);
			return;
		}
		
		
//		for(Integer i : map.keySet()) {
			
//		}
		
		Iterator<Integer> keys = map.subMap(map.firstKey(), map.lastKey()).keySet().iterator();
		while(keys.hasNext()) {
			int i = keys.next();
		if(map.get(i)!=null&&map.get(i)>0) {
			if(map.containsKey(i/d)) {
				map.put(i/d, map.get(i/d)+1);
			}
			else {
				map.put(i/d, 1);
			}
			map.put(i, map.get(i)-1);
			dfs(depth+1,threshold,d,map.get(i/d));
			
			map.put(i, map.get(i)+1);
			map.put(i/d, map.get(i/d)-1);
			
		}
		}
		
//		for(int i = maxData;i>0;i--) {
//			System.out.println(i);
			
//			if(data[i]!=0) {
//				data[i/d]++;
//				data[i]--;
//				dfs(depth+1,threshold,d,data[i/d]);
//				data[i/d]--;
//				data[i]++;
//			}
//		}
		
	}
/*
4
1
2
3
4
4
3

6

4
64
30
25
33
2
2

3
  
 */
}
