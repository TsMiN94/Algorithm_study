package BackJun;

import java.awt.*;
import java.util.Scanner;

public class BJ2193 {
    static long memo[] = new long[10000001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        memo[1] = 1;
        memo[2] = 1;
        memo[3] = 2;
        if (x < 4) {
            System.out.println(memo[x]);
        } else
            System.out.println(DP(x));
    }

    private static long DP(int x) {
        if (memo[x] == 0) {
            memo[x] = DP(x - 2) + DP(x - 1);
        }
        return memo[x];
    }
}
