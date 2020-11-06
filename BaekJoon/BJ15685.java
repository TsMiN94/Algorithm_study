package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class BJ15685 {
	static int N;
	static boolean map[][] = new boolean[101][101];
	static int dx[] = { 0, -1, 0, 1 };
	static int dy[] = { 1, 0, -1, 0 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int answer=0;
		
		N = Integer.parseInt(br.readLine());
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int y = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			int dir = Integer.parseInt(st.nextToken());
			int gen = Integer.parseInt(st.nextToken());
			makeDragonCurve(x, y, dir, gen);

		}

		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (map[i][j] && map[i][j + 1] && map[i + 1][j] && map[i + 1][j + 1])
					answer++;
			}
		}
		System.out.println(answer);

	}

	private static void makeDragonCurve(int x, int y, int dir, int gen) {

		String str = dir + "";

		int len = (int) Math.pow(2, gen);

		for (int i = 0; i < gen; i++) {
			StringBuilder sb = new StringBuilder();
			int s = str.length() - 1;
			for (int j = s; j >= 0; j--) {
				int d = str.charAt(j) - '0';
				d = (d + 1) % 4;
				sb.append(d);
			}
			str += sb.toString();
		}

		int nx = x, ny = y;
		map[x][y] = true;
		for (int i = 0; i < str.length(); i++) {
			nx += dx[str.charAt(i) - '0'];
			ny += dy[str.charAt(i) - '0'];
			map[nx][ny] = true;
		}

	}

}
