package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14719 {
	static int answer = 0;
	static int map[];
	static int N, M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[M];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < M; i++) {
			int amt = Integer.parseInt(st.nextToken());
			map[i] = amt;
		}

		for (int i = 0; i < M; i++) {
			int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, map[j]);
			}
			for (int j = i + 1; j < M; j++) {
				rMax = Math.max(rMax, map[j]);
			}
			if (lMax <= map[i] || lMax == 0)
				continue;
			if (rMax <= map[i] || rMax == 0)
				continue;

			int amt = Math.min(rMax, lMax) - map[i];
			answer += amt;
			map[i] += amt;

		}
		System.out.println(answer);

	}
}
