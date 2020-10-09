package BackJun;

import java.util.Scanner;

public class BJ1003 {
    static Fibo dp[] = new Fibo[41];
    static int target;
    static int zero = 0, one = 0;

    public static void main(String[] args) {
        dp[0] = new Fibo(0, 1, 0);
        dp[1] = new Fibo(1, 0, 1);
        dp[2] = new Fibo(2, 1, 1);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            target = sc.nextInt();
            fibo(target);
            System.out.println(dp[target].zero + " " + dp[target].one);
        }
    }

    private static Fibo fibo(int target) {
        if (target == 0) {
            return dp[0];
        }
        if (target == 1) {
            return dp[1];
        }
        if (target == 2) {
            return dp[2];
        }
        if (dp[target] == null) {
            Fibo t_2 = fibo(target - 2);
            Fibo t_1 = fibo(target - 1);
            dp[target] = new Fibo(target, t_2.zero + t_1.zero, t_2.one + t_1.one);
            return dp[target];
        } else
            return dp[target];
    }

    public static class Fibo {
        int no, zero, one;

        public Fibo(int no, int zero, int one) {
            this.no = no;
            this.zero = zero;
            this.one = one;
        }
    }
}
