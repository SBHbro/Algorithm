package programmers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution_go_hash {
	
	public static void main(String[] args) {
		System.out.println(dbl_linear(10));
//		DoubleLinear a = new DoubleLinear();
//		System.out.println(a.dbLinear(100000));
	}

	private static int dbl_linear(int n) {
		// TODO Auto-generated method stub
		
		SortedSet<Integer> set= new TreeSet<Integer>();
		set.add(1);
		int index = 0;
		while(true) {
			int temp = set.first();
			set.add(2*temp+1);
			set.add(3*temp+1);
			if(index == n) {
				break;
			}
			set.remove(set.first());
			index++;
		}
		
		int answer = 0;
//		for(int i = 0 ;i<n;i++) {
//			set.remove(set.first());
//		}
		return set.first();
	}
}
