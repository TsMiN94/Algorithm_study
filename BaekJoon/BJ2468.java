package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2468 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M, D;
	static int answer = 1;
	static StringTokenizer st;
	static int arr[][];
	static int maxH = -1;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if (arr[i][j] > maxH)
					maxH = arr[i][j];
			}
		}

		for (int i = 1; i <= maxH; i++) {
			answer = Math.max(answer, rain(i, new boolean[N][N]));
		}
		System.out.println(answer);
	}

	private static int rain(int r, boolean[][] deep) {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] <= r) {
					deep[i][j] = true;
				}
			}
		}
		boolean visited[][] = new boolean[N][N];

		for (int i = 0; i < N; i++)
			visited[i] = deep[i].clone();

		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (!deep[i][j] && !visited[i][j]) {
					DFS(i, j, visited);
					cnt++;
				}
			}

		}
		return cnt;
	}

	private static void DFS(int s, int e, boolean[][] visited) {

		int dx[] = { 0, 1, 0, -1 };
		int dy[] = { 1, 0, -1, 0 };
		visited[s][e] = true;

		for (int i = 0; i < 4; i++) {
			int nx = s + dx[i];
			int ny = e + dy[i];

			if (nx < 0 || ny < 0 || nx >= arr.length || ny >= arr.length)
				continue;
			if (visited[nx][ny])
				continue;

			DFS(nx, ny, visited);
		}

	}
}
