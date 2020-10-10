package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1149 {
    static int arr[][];
    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N + 1][4];
        dp = new int[N + 1][4];


        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= 3; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
       // for (int t[] : arr) System.out.println(Arrays.toString(t));
        for (int i = 1; i <= N; i++) {

            for (int j = 1; j <= 3; j++) {
                if (j == 1) {
                    dp[i][j] = Math.min(dp[i - 1][2], dp[i - 1][3]) + arr[i][j];
                } else if (j == 2) {
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][3]) + arr[i][j];
                } else
                    dp[i][j] = Math.min(dp[i - 1][1], dp[i - 1][2]) + arr[i][j];
            }

        }
        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= 3; i++) {
               if(answer > dp[N][i])
                   answer = dp[N][i];
        }
        System.out.println(answer);

    }
}
