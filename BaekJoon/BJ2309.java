package BaekJun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2309 {
	static int N = 9;
	static int R = 7;
	static int src[] = new int[9];
	static int arr[] = new int[7];
	static boolean flag = false;

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < 9; i++) {
			src[i] = sc.nextInt();
		}
		comb(7, 0, 0);
		//perm(7,new boolean[N],0);
	}

	public static void comb(int r, int start, int sum) {
		if (r == 0  ) {
			if (sum == 100 &&!flag) {
				Arrays.sort(arr);
				for (int j = 0; j < arr.length; j++)
					System.out.println(arr[j]);
				flag = true;
			}
			return;
		}

		for (int i = start; i < N; i++) {
			arr[r - 1] = src[i];
			comb(r - 1, i + 1, src[i] + sum);

		}

	}


}
