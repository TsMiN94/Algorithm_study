package BaekJun;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class BJ1181 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		String arr[] = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}
		HashSet<String> set = new HashSet<String>();
		set.addAll(Arrays.asList(arr));
		List list = new ArrayList<String>(set);
		
		Collections.sort(list , new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() < o2.length())
					return -1;
				else if(o1.length() == o2.length()) {
					if (o1.compareTo(o2) > 0)
						return 1;
					else
						return -1;
				}
				else
					return 1;
			}
			
			
		});
		
		
	
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));

		}


	}
}
