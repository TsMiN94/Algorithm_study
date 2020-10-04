package BackJun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ15649 {
    static int N, M;
    static int arr[], src[];
    static boolean vistied[];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        src = new int[N];
        vistied = new boolean[N];
        for (int i = 0; i < N; i++)
            src[i] = i + 1;
        perm(0);
    }

    private static void perm(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++)
                System.out.print(arr[i] + " ");
            System.out.println();
            return;
        }

        for (int i = 0; i < src.length; i++) {
            if (!vistied[i]) {
                vistied[i] = true;
                arr[cnt] = src[i];
                perm(cnt + 1);
                vistied[i] = false;
            }
        }
    }
}
