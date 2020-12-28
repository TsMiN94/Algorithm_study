package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1654 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        long arr[] = new long[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(arr);
        long start = 1;
        long end = arr[N - 1];

        long mid = (start + end) / 2;
        long sum = 0;
        while (start <= end) {
            sum = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < N; i++) {
                sum += (arr[i] / mid);
            }

            if (sum < M) {
                end = mid - 1;
            } else {
                answer = Math.max(answer, mid);
                start = mid + 1;
            }

        }
        System.out.println(answer);
    }
}
