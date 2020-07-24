package com.ssafy.algo;

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

			dfs(board, visited, 0, 0, 0, 0);
			return min;

		}

		private void dfs(int[][] board, boolean[][] visited, int currentX, int currentY, int direction, int cost) {
			if (currentX == board.length - 1 && currentY == board.length - 1) {
				min = Math.min(min, cost);
				return;

			}

			else {

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

					if(direction!=0 ) {
						if( direction != nextDir)
							cost+=500;
					}
					
					System.out.println(cost);
					System.out.println(nx + " , " + ny + "  현재 방향 " + direction + " 다음 방향 " + nextDir);
					dfs(board, visited, nx, ny, nextDir, cost);
					visited[nx][ny] = false;
				}

			}

		}

	}
}
