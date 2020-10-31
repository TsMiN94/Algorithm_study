package backjun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ2805 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());

		long tree[] = new long[N];

		long M = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			tree[i] = Long.parseLong(st.nextToken());
		}

		Arrays.sort(tree);
		long e = tree[N - 1];
		long s = 0;

		long answer= 0 ;
		while (s <= e) {
			long mid = (e + s) / 2;
			int index = Arrays.binarySearch(tree, mid);
			if (index < 0) {
				index = Math.abs(index) - 1;
			}
	
			long sum = 0;
			for (int i = index; i < N; i++) {
				if (tree[i] - mid > 0)
					sum += tree[i] - mid;
			}
			
			
			if (sum >= M) {
				answer = Math.max(answer, mid);
				s = mid + 1;
			} else if (sum < M) {
				e = mid - 1;
				
			}
		}
		
		


		System.out.println(answer);

	}
}
