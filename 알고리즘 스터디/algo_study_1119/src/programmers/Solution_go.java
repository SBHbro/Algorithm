package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Solution_go {
	
	public static void main(String[] args) {
		System.out.println(dbl_linear(10));
	}

	private static int dbl_linear(int n) {
		// TODO Auto-generated method stub
		
		int index = 0;
		List<Integer> data = new ArrayList<>();
		data.add(1);
		while(index<n) {
			data.add(2*data.get(index)+1);
			data.add(3*data.get(index)+1);
			index++;
		}
		
		
		Collections.sort(data,new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				if(o1>o2) {
					return 1;
				}
				else {
					return -1;
				}
			}
		});
		
		return data.get(n);
	}
}
