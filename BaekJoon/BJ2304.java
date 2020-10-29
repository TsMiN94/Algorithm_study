package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2304 {
	static int answer = 0;
	static int map[];


	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[10001];
		int max= 0;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int index = Integer.parseInt(st.nextToken());
			max = Math.max(max, index);
			int h = Integer.parseInt(st.nextToken());
			map[index] = h;
		}
		
		for (int i = 0; i <= max; i++) {
			int lMax = Integer.MIN_VALUE, rMax = Integer.MIN_VALUE;
			for (int j = 0; j < i; j++) {
				lMax = Math.max(lMax, map[j]);
			}
			for (int j = i + 1; j <= max; j++) {
				rMax = Math.max(rMax, map[j]);
			}
			if (lMax <= map[i] || lMax == 0)
				continue;
			if (rMax <= map[i] || rMax == 0)
				continue;

			int amt = Math.min(rMax, lMax) - map[i];

			map[i] += amt;

		}
		for(int i =0 ; i <=max; i++)
			answer +=map[i];
		System.out.println(answer);

	}
}
