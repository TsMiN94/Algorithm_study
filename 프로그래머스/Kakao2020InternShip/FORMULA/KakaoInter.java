package com.ssafy.algo;

import java.util.LinkedList;
import java.util.Queue;

public class KakaoInter {
	public static void main(String[] args) {
		int[][] arr = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };
	
		Solution s = new Solution();
		System.out.println(s.solution(arr));
	}

	static class Solution {
		static int min = Integer.MAX_VALUE;
		int[] dx = { -1, 0, 1, 0 };
		int[] dy = { 0, 1, 0, -1 };

		public int solution(int[][] board) {
			int answer = 0;
			int x = 0, y = 0;

			int len = board.length;
			boolean visited[][] = new boolean[len][len];

			// dfs(board, visited, 0, 0, 0, 0);
			return bfs(board, visited);

		}

		private int bfs(int[][] board, boolean[][] visited) {
			Queue<Point> q = new LinkedList<Point>();
			int answer = Integer.MAX_VALUE;
			q.add(new Point(0, 0, 0, -1));

			int dx[] = { 0, 1, 0, -1 };
			int dy[] = { 1, 0, -1, 0 };

			while (!q.isEmpty()) {

				Point cur = q.poll();
				if (cur.x == board.length - 1 && cur.y == board.length - 1) {
					answer = Math.min(answer, cur.cost);
					continue;
				}
				for (int i = 0; i < 4; i++) {

					int nx = cur.x + dx[i];
					int ny = cur.y + dy[i];

					if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length || board[nx][ny] == 1)
						continue;

					int nextCost = 0;
					if (cur.dir == -1 || cur.dir == i) {
						nextCost = cur.cost + 100;
					} else if (cur.dir != i) {
						nextCost = cur.cost + 600;
					}

					if (board[nx][ny] == 0) {
						board[nx][ny] = nextCost;
						q.add(new Point(nx, ny, nextCost, i));
					} else if (board[nx][ny] >= nextCost) {
						board[nx][ny] = nextCost;
						q.add(new Point(nx, ny, nextCost, i));
					}

				}

			}
				return answer;
		}

		// dfs로는 시간초과가 나버린다...
		private void dfs(int[][] board, boolean[][] visited, int currentX, int currentY, int direction, int cost) {
			if (currentX == board.length - 1 && currentY == board.length - 1) {
				min = Math.min(min, cost);
				return;
			} else {
				for (int i = 0; i < 4; i++) {
					int nx = dx[i] + currentX;
					int ny = dy[i] + currentY;

					if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
						continue;
					}
					if (visited[nx][ny])
						continue;
					// up right down left

					visited[nx][ny] = true;
					cost += 100;
					int nextDir = 0;

					// 수평
					if (i % 2 == 0)
						nextDir = 1;
					// 수직
					else
						nextDir = -1;

					if (direction != 0) {
						if (direction != nextDir)
							cost += 500;
					}

					System.out.println(cost);
					System.out.println(nx + " , " + ny + "  현재 방향 " + direction + " 다음 방향 " + nextDir);
					dfs(board, visited, nx, ny, nextDir, cost);
					visited[nx][ny] = false;
				}

			}

		}

	}

	static class Point {

		int x, y, cost, dir;

		public Point(int x, int y, int cost, int dir) {
			super();
			this.x = x;
			this.y = y;
			this.cost = cost;
			this.dir = dir;
		}

	}
}
