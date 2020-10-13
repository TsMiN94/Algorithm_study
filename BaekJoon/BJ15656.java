package BackJun;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BJ15656 {
    static int src[];
    static int arr[];
    static int N, M;
    static boolean visited[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(src);
        perm(0);
        bw.flush();
        bw.close();

    }

    private static void perm(int cnt) throws IOException {
        if (cnt == M) {

            for (int i = 0; i < arr.length; i++)
                bw.write(arr[i] + " ");

            bw.write("\n");
            return;
        }
        for (int i = 0; i < src.length; i++) {

                arr[cnt] = src[i];
                perm(cnt + 1);

            }



    }
}
