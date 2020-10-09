package BackJun;

import java.util.Arrays;
import java.util.Scanner;



public class BJ2839 {
    static int answer = 0;
    static int target;
    static int dp[] = new int[50001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        target = sc.nextInt();
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[3] = 1;
        dp[5] = 1;
        answer = find(target);
        if (answer != Integer.MAX_VALUE)
            System.out.println(answer);
        else
            System.out.println(-1);
    }

    private static int find(int target) {
        if (target <= 5) {
            return dp[target];
        }

        if (dp[target] == Integer.MAX_VALUE) {
            int min = Math.min(find(target - 3), find(target - 5));
            if (min == Integer.MAX_VALUE) dp[target] = Integer.MAX_VALUE;
            else dp[target] = 1 + min;
        }
        return dp[target];
    }


}
