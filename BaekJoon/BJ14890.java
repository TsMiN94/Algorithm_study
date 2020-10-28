package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14890 {
	static int triangleLen;
	static int answer = 0;
	static int map[][];
	static int N;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		triangleLen = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < N; i++) {
			if (check(i, 0, 0)) {
				answer++;
			}
			if (check(0, i, 1)) {
				answer++;
			}
		}

		System.out.println(answer);

	}

	private static boolean check(int x, int y, int dir) {
		boolean visited[] = new boolean[N];
		int h[] = new int[N];

		for (int i = 0; i < N; i++) {
			if (dir == 0) {
				h[i] = map[x][y + i];
			} else
				h[i] = map[x + i][y];
		}

		for (int i = 0; i < N - 1; i++) {
			if (h[i] == h[i + 1])
				continue;

			if (Math.abs(h[i] - h[i + 1]) > 1)
				return false;

			// down
			if (h[i] - h[i + 1] == 1) {
				// 삼각형 길이만큼 검사
				for (int j = i + 1; j <= i + triangleLen; j++) {
					if (j >= N || visited[j] || h[j] != h[i + 1])
						return false;
					visited[j] = true;
				}
			}
			// up
			else if (h[i + 1] - h[i] == 1) {
				for (int j = i; j > i - triangleLen; j--) {
					if (j < 0 || visited[j] || h[i] != h[i])
						return false;
					visited[j] = true;
				}
			}

		}

		return true;
	}
}
