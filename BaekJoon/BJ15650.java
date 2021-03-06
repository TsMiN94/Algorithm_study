package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;
import java.util.StringTokenizer;

public class BJ15650 {
    static int src[];
    static int arr[];

    static int N, M;
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            src[i] = i + 1;
        }

        perm(0);

    }

    private static void perm(int cnt) {
        if (cnt == M) {
            boolean flag = true;
            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) flag = false;
            }

            if (flag) {
                for (int i = 0; i < arr.length; i++) {
                    System.out.print(arr[i] + " ");
                }
                System.out.println();
            }
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = src[i];
                perm(cnt + 1);
                visited[i] = false;
            }

        }

    }
}
