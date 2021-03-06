package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ2470 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    static int N, K;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        int arr[] = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        int a = 0, b = 0;
        int s = 0;
        int e = N - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (Math.abs(sum) < Math.abs(answer)) {
                a = arr[s];
                b = arr[e];
                answer = sum;
            }
            if (sum > 0) e--;
            else if (sum < 0) s++;
            else break;
        }
        System.out.println(a+" "+b);
    }
}
