package BaekJun;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BJ2798 {
	static int answer = 0;
	static int M, N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		int arr[] = new int[N];
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			map.put(arr[i], i);
		}

		for (int i = 0; i < N; i++) {
			boolean visited[] = new boolean[N];

			perm(visited, arr, i, 0, 0);
		}
		System.out.println(answer);

	}

	private static void perm(boolean[] visited, int[] arr, int i, int cnt, int sum) {
		if (cnt == 3) {
			if (sum <= M) {
				answer = Math.max(sum, answer);
				
			}
			return;
		}
		cnt += 1;
		for (int j = i; j < N; j++) {
			if (visited[j])
				continue;
			visited[j] = true;
			perm(visited, arr, j, cnt, sum +arr[j]);
			visited[j] = false;
		}

	}

}
