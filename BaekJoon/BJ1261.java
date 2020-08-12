package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1261 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int arr[][];
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[M][N];

		for (int i = 0; i < M; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		//DFS(0, 0);
		BFS(0, 0);
		System.out.println(answer);
	}

	private static void BFS(int r, int c) {
		//Queue<Point> q = new LinkedList<Point>();
		PriorityQueue<Point> q= new PriorityQueue<>();
		boolean visited[][] = new boolean[M][N];
		q.add(new Point(r, c, 0));
		visited[r][c] = true;
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.x == M - 1 && cur.y == N - 1) {
				answer = Math.min(answer, cur.cost);
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny])
					continue;
				visited[nx][ny] = true;
				if (arr[nx][ny] == 1) {
					q.add(new Point(nx, ny, cur.cost + 1));
				} else {
					q.add(new Point(nx, ny, cur.cost));
				}
				System.out.println(nx + " , " + ny);
			}
		}
	}

	public static class Point implements Comparable<Point> {
		int x, y, cost;

		public Point(int x, int y, int cost) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
		}

		@Override
		public int compareTo(Point o) {
			
			return Integer.compare(this.cost ,o.cost);
		}
		
	}

	private static void DFS(int r, int c) {

		if (r == M - 1 && c == N - 1) {
			answer = Math.min(answer, arr[r][c]);
		}
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		for (int i = 0; i < 4; i++) {
			int nx = r + dx[i];
			int ny = c + dy[i];
			if (nx < 0 || ny < 0 || nx >= M || ny >= N)
				continue;
			int cnt = (arr[nx][ny] == 0) ? arr[r][c] : arr[r][c] + 1;
			if (cnt < arr[nx][ny]) {
				arr[nx][ny] = cnt;
				DFS(nx, ny);
			}
		}

	}
}
