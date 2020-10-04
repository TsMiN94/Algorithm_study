package BackJun;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Scanner;

public class BJ15652 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int arr[], src[];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        src = new int[N];
        for (int i = 0; i < N; i++)
            src[i] = i + 1;
        comb(0, 0);
        bw.flush();
        bw.close();
    }

    private static void comb(int cnt, int start) throws IOException {
        if (cnt == M) {
            for (int i = 0; i < arr.length; i++) {
                bw.write(arr[i] + " ");
            }
            bw.write("\n");
            return;
        }

        for (int i = start; i < src.length; i++) {
            arr[cnt] = src[i];
            comb(cnt + 1, i);
        }
    }
}
