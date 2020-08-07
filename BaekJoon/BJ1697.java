package BaekJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;





public class BJ1697 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int N, K;
	static int answer = 0;
	static StringTokenizer st;
	static boolean visited[];

	public static void main(String[] args) throws IOException {
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		visited = new boolean[K + 1];
		subSet(N, 0);
		System.out.println(answer);
	}

	private static void subSet(int n, int time) {
		Queue<Integer> q = new LinkedList<Integer>();
		int offset[] = { -1, 1, 2 };
		q.add(n);

		visited[N] = true;
		while (!q.isEmpty()) {

			int curN = q.poll();

			for (int i = 0; i < offset.length; i++) {
				int nextN;
				if (i == 2) {
					nextN = curN * 2;
				} else {
					nextN = offset[i] + curN;
				}
				if (nextN < 0 || nextN > 17)
					continue;
				if (visited[nextN])
					continue;
				answer++;
				if (curN == K)
					return;
				q.add(nextN);

			}

		}

	}
	
}
