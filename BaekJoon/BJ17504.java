package BackJun;

import java.util.Scanner;

public class BJ17504 {
    static int N;
    static int steal[];
    static long answer, remain, stole, whole;
    static long c, p;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        steal = new int[N];
        for (int i = 0; i < N; i++) {
            steal[i] = sc.nextInt();
        }
        jerry(0);

        System.out.println(p - c + " " + p);
    }

    private static void jerry(int cnt) {
        if (cnt == N - 1) {
            long sAmout = steal[cnt];
            p = sAmout;
            c = 1;
            return;
        }
        jerry(cnt + 1);
        long newChilid = steal[cnt] * p + c;
        long temp = p;
        p = newChilid;
        c = temp;
    }
}
