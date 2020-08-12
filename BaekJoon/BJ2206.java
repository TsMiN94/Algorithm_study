package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2206 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int arr[][];
	static StringTokenizer st;
	static int answer = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		arr = new int[N][M];

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < str.length(); j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}

		BFS(0, 0);
		System.out.println(answer);
	}

	private static void BFS(int r, int c) {

		boolean flag = false;
		Queue<Point> q = new LinkedList<>();
		boolean visited[][][] = new boolean[2][N][M];
		q.add(new Point(r, c, 1, 0));
		Point cur = null;
		visited[1][r][c] = true;
		int dx[] = { -1, 0, 1, 0 };
		int dy[] = { 0, -1, 0, 1 };
		while (!q.isEmpty()) {
			cur = q.poll();
			if (cur.x == N - 1 && cur.y == M - 1) {
				answer = Math.min(answer, cur.cost);
				flag = true;
			}
			for (int i = 0; i < 4; i++) {
				int nx = cur.x + dx[i];
				int ny = cur.y + dy[i];
				if (nx < 0 || ny < 0 || nx >= N || ny >= M)
					continue;

				if (cur.breakCnt == 1) {
					if (arr[nx][ny] == 0 && !visited[cur.breakCnt][nx][ny]) {
						q.add(new Point(nx, ny, cur.cost + 1, cur.breakCnt));
						visited[cur.breakCnt][nx][ny] = true;
					}
				} else {
					if (arr[nx][ny] == 1) {
						if (!visited[cur.breakCnt + 1][nx][ny]) {
							q.add(new Point(nx, ny, cur.cost + 1, cur.breakCnt + 1));
							visited[cur.breakCnt][nx][ny] = true;
						}
					} else if (arr[nx][ny] == 0) {
						if (!visited[cur.breakCnt][nx][ny]) {
							q.add(new Point(nx, ny, cur.cost + 1, cur.breakCnt));
							visited[cur.breakCnt][nx][ny] = true;
						}
					}
				}
			}
		}
		
		if (!flag)answer = -1;

	}

	public static class Point  {
		int x, y, cost;
		int breakCnt;

		public Point(int x, int y, int cost, int bc) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.breakCnt = bc;
		}

	

	}

}
