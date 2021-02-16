package study_0216;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution_J_1828_≥√¿Â∞Ì {

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[][] chems = new int[n][2];
		for(int i = 0; i < n; i++) {
			chems[i][0] = in.nextInt();
			chems[i][1] = in.nextInt();
		}
		in.close();
		
		Arrays.sort(chems, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] <= b[0] ? -1 : 1;
			}
		});
		
		for(int[] chem : chems)
			System.out.printf("%3d, %3d\n", chem[0], chem[1]);
		
		ArrayList<int[]> list = new ArrayList<int[]>();
		list.add(chems[0]);
		System.out.println();
		outloop : for(int i = 1; i < chems.length; i++) {
			int[] chem = chems[i];
			
			for(int j = 0; j < list.size(); j++) {
				int[] ref = list.get(j);
				
				if(ref[1] >= chem[0]) {
					ref[0] = ref[0] >= chem[0] ? ref[0] : chem[0];
					ref[1] = ref[1] <= chem[1] ? ref[1] : chem[1];
					continue outloop;
				}
			}
			System.out.printf("%3d, %3d\n",chem[0],chem[1]);
			list.add(chem);
		}
		System.out.println();
		for(int[] a : list)
			System.out.printf("%3d, %3d\n",a[0],a[1]);
		System.out.println(list.size());
	}
}