package BaekJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class BJ3040 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int src[], arr[];
	static boolean visited[];
	static Scanner sc = new Scanner(System.in);
	static boolean flag = true;

	public static void main(String[] args) {
		src = new int[9];
		arr = new int[7];
		for (int i = 0; i < 9; i++) {
			src[i] = sc.nextInt();
		}
		comb(0, 0);

	}

	public static void comb(int cnt, int start) {
		if (cnt == 7) {
			if (flag) {
				int sum = 0;
				for (int i = 0; i < arr.length; i++)
					sum += arr[i];

				if (sum == 100) {
					Arrays.sort(arr);

					for (int i = 0; i < arr.length; i++) {
						System.out.println(arr[i]);
					}
					flag = false;
				}
			}
			return;
		}

		for (int i = start; i < src.length; i++) {
			arr[cnt] = src[i];
			comb(cnt + 1, i + 1);
		}
	}
}
