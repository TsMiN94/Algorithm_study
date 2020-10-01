package BackJun;

import java.util.Scanner;

public class BJ10844 {
    static long memo[][];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        memo = new long[target][10];
        for (int i = 1; i < 10; i++) {
            memo[0][i] = 1;

            if (i == 9) {
                memo[1][i] = 1;
            } else
                memo[1][i] = 2;
        }

        if (target == 1) {
            System.out.println(9);
        } else if (target == 2) {
            System.out.println(17);
        } else {
            DP(target);
            long sum = 0;
            for (int i = 1; i < 10; i++) {
                sum += memo[target - 1][i];
            }
            System.out.println(sum % 1000000000);
        }
    }

    private static void DP(int target) {
        for (int i = 2; i < target; i++) {

            for (int j = 1; j < 10; j++) {
                if (j == 1) {
                    memo[i][j] = (memo[i - 2][j] + memo[i - 1][j + 1]) % 1000000000;
                } else if (j == 9) {
                    memo[i][j] = (memo[i - 1][j - 1]) % 1000000000;
                } else
                    memo[i][j] = (memo[i - 1][j - 1] + memo[i - 1][j + 1]) % 1000000000;
            }

        }
    }
}
