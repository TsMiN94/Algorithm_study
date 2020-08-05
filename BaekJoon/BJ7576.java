package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ7576 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, M;
	static int arr[][];
	static boolean visited[][];

	public static void main(String[] args) throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[M][N];
		visited = new boolean[M][N];
		int r = 0, c = 0;
		ArrayList<Tomato> startTomato = new ArrayList<Tomato>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				int tomato = Integer.parseInt(st.nextToken());
				arr[i][j] = tomato;
				if (tomato == 1) {
					startTomato.add(new Tomato(i, j));
				}
			}
		}
		int answer = bfs(startTomato);
		System.out.println(answer);
	}

	private static int bfs(ArrayList<Tomato> startTomato) {
		int dx[] = { 1, 0, -1, 0 };
		int dy[] = { 0, 1, 0, -1 };
		int day = 0;
		if (beforeCheck()) {
			return 0;
		} else {

			Queue<Tomato> q = new LinkedList<Tomato>();
			for (int i = 0; i < startTomato.size(); i++) {
				Tomato startT = startTomato.get(i);
				q.add(startT);
				visited[startT.x][startT.y] = true;
			}

			while (!q.isEmpty()) {
				int size = q.size();
				while (--size >= 0) {
					Tomato tomato = q.poll();
					for (int i = 0; i < 4; i++) {
						int nx = tomato.x + dx[i];
						int ny = tomato.y + dy[i];
						if (nx < 0 || ny < 0 || ny >= N || nx >=M)
							continue;
						if (visited[nx][ny] || arr[nx][ny] == -1 || arr[nx][ny] == 1)
							continue;
						
						q.add(new Tomato(nx, ny));
						visited[nx][ny] = true;
						arr[nx][ny] = 1;
					}
				}
				day++;
			}
		}
		if (check()) {
			return day-1;
		} else {
			return -1;
		}

	}

	private static boolean beforeCheck() {
	
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] != -1 && arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	private static boolean check() {
	

		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	static public class Tomato {
		int x, y;

		public Tomato(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}

	}
}
