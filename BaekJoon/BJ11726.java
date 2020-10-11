package BackJun;

import java.util.Scanner;

public class BJ11726 {
    static int dp[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        dp = new int[target + 1];
        dp[1] = 1;
        dp[2] = 2;
        if (target > 2)
            DP(target%10007);
        System.out.println(dp[target]%10007);
    }

    private static int DP(int target) {
        if (dp[target] == 0)
            dp[target] = (DP(target - 2) % 10007 + DP(target - 1) % 10007) % 10007;
        return dp[target] % 10007;
    }
}
