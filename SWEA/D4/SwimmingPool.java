package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class SwimmingPool {
    static int answer = Integer.MAX_VALUE;
    static int year[] = new int[13];
    static int dp[] = new int[13];
    static int bills[] = new int[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < 4; i++) {
                bills[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= 12; i++)
                year[i] = Integer.parseInt(st.nextToken());

            check(1, 0);
            if( answer >bills[3])
            answer = bills[3];
            System.out.println("#"+t+" " +answer);
            answer = Integer.MAX_VALUE;
        }
    }

    private static void check(int month, int sum) {

        if (month > 12) {
            answer = Math.min(sum, answer);
            return;
        }

        check(month + 1, sum + (year[month] * bills[0]));
        check(month + 1, sum + bills[1]);
        check(month + 3, sum + bills[2]);


    }
}
