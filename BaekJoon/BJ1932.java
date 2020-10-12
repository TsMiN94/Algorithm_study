package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1932 {
    static int dp[][];
    static int arr[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new int[N][];
        dp = new int[N][];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int size = st.countTokens();
            arr[i] = new int[size];
            dp[i] = new int[size];
            for (int j = 0; j < size; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = arr[0][0];
        dp[1][0] = arr[0][0] + arr[1][0];
        dp[1][1] = arr[0][0] + arr[1][1];

        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                for (int k = j; k < j + 2; k++) {
                    if (dp[i+1][k] < arr[i+1][k] + dp[i][j])
                        dp[i+1][k] = arr[i+1][k] + dp[i][j];
                }
            }
        }

        Arrays.sort(dp[N-1]);
        System.out.println(dp[N-1][N-1]);

    }
}
