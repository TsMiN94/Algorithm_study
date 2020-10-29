package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2636 {
	static int map[][];
	static int time;
	static int dx[] = { 1, -1, 0, 0 };
	static int dy[] = { 0, 0, 1, -1 };
	static int N, M;
	static int answer = 0;
	static int c = 0;
	static Queue<Point> removeQue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];

		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if (map[i][j] == 1)
					c++;
			}
		}

		while (true) {
			BFS(0, 0);

			time++;
			if (removeQue.size() == c)
				break;
			while (!removeQue.isEmpty()) {
				Point cheeze = removeQue.poll();
				map[cheeze.x][cheeze.y] = 0;
				c--;
			}
		}

		answer = removeQue.size();
		
		System.out.println(time);
		System.out.println(answer);
	}

	private static void BFS(int x, int y) {
		boolean visited[][] = new boolean[N][M];
		Queue<Point> q = new LinkedList<>();
		visited[x][y] = true;
		q.add(new Point(x, y));

		while (!q.isEmpty()) {
			Point cur = q.poll();
		
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];

				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;
				if (map[nx][ny] == 1) {
					map[nx][ny] = -1;
					removeQue.add(new Point(nx, ny));
				} else if (map[nx][ny] == 0 && !visited[nx][ny]) {
					q.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}

	}

	static public class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
