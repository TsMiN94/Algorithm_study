package BackJun;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class BJ15657 {
    static int src[];
    static int arr[];
    static int N, M;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new int[M];
        src = new int[N];
        for (int i = 0; i < N; i++)
            src[i] = sc.nextInt();
        Arrays.sort(src);
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
            comb(cnt + 1, i );
        }
    }
}
