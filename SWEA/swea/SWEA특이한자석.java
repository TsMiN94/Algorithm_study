package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SWEA특이한자석 {
	static int gear[][];
	static int answer = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			gear = new int[4][8];
			int s = Integer.parseInt(br.readLine());
			for (int i = 0; i < 4; i++) {
				StringTokenizer st= new StringTokenizer(br.readLine());
				for (int j = 0; j < 8; j++)
					gear[i][j] = Integer.parseInt(st.nextToken());
			}

			for (int i = 0; i < s; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int gearIdx = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				move(gearIdx - 1, dir);
			}
			int point = 1;
		
			for (int i = 0; i < 4; i++) {
				if (gear[i][0] == 1)
					answer += point;
				point *= 2;
			}
			System.out.println("#" + t + " " + answer);
			answer = 0;
		}
	}

	private static void move(int gearIdx, int dir) {
		left(gearIdx - 1, dir * -1);
		right(gearIdx + 1, dir * -1);
		rotate(gearIdx, dir);

	}

	static void left(int idx, int dir) {
		if (idx < 0)
			return;

		if (gear[idx][2] != gear[idx + 1][6]) {
			left(idx - 1, -dir);
			rotate(idx, dir);
		}
	}

	static void right(int idx, int dir) {
		if (idx > 3)
			return;

		if (gear[idx][6] != gear[idx - 1][2]) {
			right(idx + 1, -dir);
			rotate(idx, dir);
		}
	}

	private static void rotate(int gearIdx, int dir) {
		if (dir == 1) {
			int temp = gear[gearIdx][7];
			for (int i = 7; i > 0; i--) {
				gear[gearIdx][i] = gear[gearIdx][i - 1];
			}
			gear[gearIdx][0] = temp;
		} else {
			int temp = gear[gearIdx][0];
			for (int i = 0; i < 7; i++) {
				gear[gearIdx][i] = gear[gearIdx][i + 1];
			}
			gear[gearIdx][7] = temp;
		}
	}
}
