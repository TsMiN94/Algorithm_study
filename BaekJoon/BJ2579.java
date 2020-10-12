package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

public class BJ2579 {
    static int dp[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        dp = new int[N];
        int arr[] = new int[301];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        if (0 < N)
            dp[0] = arr[0];
        if (1 < N)
            dp[1] = arr[0] + arr[1];
        if (2 < N)
            dp[2] = Math.max(arr[0] + arr[2], arr[1] + arr[2]);

        for (int i = 3; i < N; i++) {
            dp[i] = Math.max(dp[i - 2] + arr[i], arr[i] + arr[i - 1] + dp[i - 3]);
        }

        System.out.println(dp[N - 1]);

    }
}
