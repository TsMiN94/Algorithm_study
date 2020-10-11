package BackJun;

import java.util.Scanner;

public class BJ9095 {
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int answer = 0;
            int target = sc.nextInt();
            dp = new int[target + 1];
            DP(target);

            System.out.println(dp[target]);
        }


    }

    private static int DP(int target) {
        if (target == 1) {
            dp[1] = 1;
            return dp[1];
        }
        if (target == 2) {
            dp[2] = 2;
            return dp[2];
        }
        if (target == 3) {
            dp[3] = 4;
            return dp[3];
        }
        if (dp[target] == 0)
            dp[target] = DP(target - 1) + DP(target - 2) + DP(target - 3);

        return dp[target];

    }
}
