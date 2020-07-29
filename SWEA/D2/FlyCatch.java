package com.ssafy.algo.swea;

import java.util.Scanner;

public class D2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int max = 0;
			int[][] board = new int[N][N];
			int[][] flyStick = new int[M][M];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					board[i][j] = sc.nextInt();
				}
			}

			int sum = 0;
			int curX = 0, curY = 0;

			// 파리채 이동
			for (int x = 0; x < board.length - M + 1; x++) {
				for (int y = 0; y < board.length - M + 1; y++) {
					// 파리채안의 파리갯수 계산
					int r = x + M;
					int c = y + M;
					for (int i = x; i < r; i++) {
						for (int j = y; j < c; j++) {
							sum += board[i][j];
						}
					}
					max = Math.max(max, sum);
					sum =0;
				}
			}
			System.out.println("#"+test_case + " " + max);
		}

	}
}
