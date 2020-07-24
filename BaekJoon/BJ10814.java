package com.ssafy.algo;

import java.util.*;

public class BJ10814 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String[][] array = new String[N][2];

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < N; i++) {
			String age = sc.next();
			String name = sc.next();
			array[i][0] = age;
			array[i][1] = name;
			map.put(name, i);
		}

		Arrays.sort(array, new Comparator<String[]>() {
			@Override
			public int compare(String[] o1, String[] o2) {

				
				return Integer.compare(Integer.parseInt(o1[0]) , Integer.parseInt(o2[0]));

			}
		});
		for (int i = 0; i < array.length; i++) {
			System.out.println(array[i][0] +" " + array[i][1]);

		}

	}
}
