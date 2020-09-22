package BackJun;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;


public class BJ1463 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    private static int x;
    static int memo[] = new int[1000001];

    public static void main(String[] args) throws IOException {
        x = Integer.parseInt(reader.readLine());
        System.out.println(DP(x));

    }

    private static int DP(int x) {
        if (x == 1) {
            memo[1] = 0;
            return 0;
        }
        if (x == 2) {
            memo[2] = 1;
            return 1;
        }
        if (x == 3) {
            memo[3] = 1;
            return 1;
        }


        if (memo[x] == 0) {
            if (x % 3 == 0 && x % 2 == 0) {
                memo[x] = Math.min(DP(x / 3) + 1, DP(x / 2) + 1);
            } else if (x % 3 == 0 && x % 2 != 0) {
                memo[x] = Math.min(DP(x / 3) + 1, DP(x - 1) + 1);
            } else if (x % 3 != 0 && x % 2 == 0) {
                memo[x] = Math.min(DP(x / 2) + 1, DP(x - 1) + 1);
            } else {
                memo[x] = DP(x - 1) + 1;
            }
        }


        return memo[x];
    }

}
