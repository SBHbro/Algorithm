package programmers;

import java.util.SortedSet;
import java.util.TreeSet;

public class DoubleLinear {
public static final int FIRST_NUM = 1;
	
	public static int dbLinear(int n) {
		int first = FIRST_NUM;
		SortedSet<Integer> list = new TreeSet<>();
		list.add(first);
		for(int i= 0; i<n;i++) {
			list.add(function1(list.first()));
			list.add(function2(list.first()));
			list.remove(list.first());
		}
		return list.first();
	}
	
	private static Integer function1(Integer a) {return (2*a)+1;}
	private static Integer function2(Integer a) {return (3*a)+1;}
}
