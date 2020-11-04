package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2580 {
	static int map[][] = new int[9][9];
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 9; i++) {
		StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sdoku(0, 0);

	}

	private static void sdoku(int x, int y) {
		if (flag)
			return;
		
		if (y>8) {
			if (x == 8) {
				flag = true;
				for (int i = 0; i < 9; i++) {
					for (int j = 0; j < 9; j++) {
						System.out.print(map[i][j]+" ");
					}
					System.out.println();
				}
				return;
			} else {
				x = x + 1;
				y = 0;
			}
		}

		if (map[x][y] == 0) {

			for (int i = 1; i < 10; i++) {
				if (rowCheck(y, i) && colCheck(x, i) && sqCheck(x, y, i)) {
					map[x][y] = i;
					sdoku(x, y +1);
					map[x][y] = 0;
				}
			}
		} else {
			sdoku(x, y + 1);
		}

	}

	private static boolean rowCheck(int y, int n) {

		for (int r = 0; r < 9; r++) {
			if (map[r][y] == n) {
				return false;
			}
		}

		return true;
	}

	private static boolean colCheck(int x, int n) {

		for (int c = 0; c < 9; c++) {
			if (map[x][c] == n) {
				return false;
			}
		}

		return true;
	}

	private static boolean sqCheck(int x, int y, int n) {
		int sx = (x / 3) * 3;
		int sy = (y / 3) * 3;
		for (int i = sx; i < sx + 3; i++) {
			for (int j = sy; j < sy + 3; j++) {
				if (map[i][j] == n) {
					return false;
				}
			}
		}
		return true;
	}
}
