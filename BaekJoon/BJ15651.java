package BackJun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BJ15651 {
    static int N, M;
    static int arr[], src[];
    static boolean vistied[];
    static BufferedWriter bw;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
         bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        src = new int[N];
        vistied = new boolean[N];
        for (int i = 0; i < N; i++)
            src[i] = i + 1;
        perm(0);
        bw.flush();
        bw.close();
    }

    private static void perm(int cnt) throws IOException {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++)
                bw.write(arr[i]+" ");
          bw.write("\n");

            return;
        }

        for (int i = 0; i < src.length; i++) {
            arr[cnt] = src[i];
            perm(cnt + 1);
        }

    }
}
