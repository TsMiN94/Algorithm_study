package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class BJ4963 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int answer = 0;
	static int W, H;
	static int[][] map;
static 	boolean visited[][];
	public static void main(String[] args) throws IOException {
		String line;
		while ((line = br.readLine()) != null) {
			StringTokenizer st = new StringTokenizer(line);
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			if(W== 0 && H == 0) return;
			map = new int[H][W];
			visited = new boolean[H][W];
			for (int i = 0; i < H; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < W; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			for (int i = 0; i < H; i++) {
				for (int j = 0; j < W; j++) {
					if (map[i][j] == 1 &&!visited[i][j])
						bfs(i, j);
				}
			}
			

			System.out.println(answer);
			answer= 0;
		}
	}

	private static void bfs(int r, int c) {
		int dx[] = { 1, 0, -1, 0, 1, 1, -1, -1 };
		int dy[] = { 0, -1, 0, 1, -1, 1, 1, -1 };

		Queue<Point> q = new LinkedList<Point>();
		q.add(new Point(r, c));
		visited[r][c] = true;

		while (!q.isEmpty()) {
			Point point = q.poll();
			for (int i = 0; i < 8; i++) {
				int nx = point.x + dx[i];
				int ny = point.y + dy[i];
				if (nx < 0 || ny < 0 || ny >= W || nx >= H)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				q.add(new Point(nx, ny));
				visited[nx][ny] = true;

			}
		}
		answer++;
	}

	public static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
