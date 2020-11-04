package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ2458 {
	static int N, M;
	static int d[];

	static int answer = 0;
	static int arr[][];
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
	
		
		d = new int[N];
		visited = new boolean[N];
		arr = new int[N][N];
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int no = Integer.parseInt(st.nextToken()) - 1;
			int to = Integer.parseInt(st.nextToken()) - 1;
			arr[no][to] = 1;
		}

		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				if (i == k)
					continue;
				for (int j = 0; j < N; j++) {
					if (i == j || j == k)
						continue;
					if (arr[i][k] == 1 && arr[k][j] == 1 && arr[i][j] == 0)
						arr[i][j] = 1;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 1) {
					d[i]++;
				}
				if (arr[j][i] == 1) {
					d[i]++;
				}
			}
			if (d[i] == N - 1)
				answer++;
		}

		System.out.println(answer);

	}

}
