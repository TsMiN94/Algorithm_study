package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class BJ2667 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N;
	static int map[][];

	static int max = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());

		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			String line = br.readLine();
			for (int j = 0; j < N; j++) {
				map[i][j] = line.charAt(j) - '0';
			}
		}
		boolean[][] visited = new boolean[N][N];
		ArrayList<Integer> list = new ArrayList<Integer>();
		//		bfs
		//		for (int i = 0; i < N; i++) {
		//			for (int j = 0; j < N; j++) {
		//				if (map[i][j] == 1 && !visited[i][j])
		//					list.add(BFS(i, j, visited));
		//			}
		//		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (map[i][j] == 1 && !visited[i][j]) {
					DFS(i, j, visited);
					list.add(max);
					max = 0;
				}
			}
		}

		Collections.sort(list);
		System.out.println(list.size());
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}

	}

	private static void DFS(int r, int c, boolean[][] visited) {
		max++;
		visited[r][c] = true;
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		Point p = new Point(r, c);

		for (int i = 0; i < 4; i++) {
			int nx = p.x + dx[i];
			int ny = p.y + dy[i];
			if (nx < 0 || ny < 0 || ny >= N || nx >= N)
				continue;
			if (visited[nx][ny] || map[nx][ny] == 0)
				continue;
			DFS(nx, ny, visited);
		}
	
	}

	private static int BFS(int r, int c, boolean[][] visited) {
		Queue<Point> q = new LinkedList<Point>();
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };

		visited[r][c] = true;
		q.add(new Point(r, c));
		int cnt = 1;
		while (!q.isEmpty()) {
			Point p = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				if (nx < 0 || ny < 0 || ny >= N || nx >= N)
					continue;
				if (visited[nx][ny] || map[nx][ny] == 0)
					continue;

				q.add(new Point(nx, ny));
				cnt++;
				visited[nx][ny] = true;

			}

		}

		return cnt;
	}

	private static class Point {
		int x, y;

		public Point(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
