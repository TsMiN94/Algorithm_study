package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ14888 {
    static int N;
    static int src[];
    static int op[] = new int[4];
    static long min = 1000000000;
    static long max = -1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        src = new int[N];
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++)
            op[i] = Integer.parseInt(st.nextToken());

        DFS(0, src[0]);
        System.out.println(max);
        System.out.println(min);
    }

    private static void DFS(int cnt, long num) {

        if (cnt == N - 1) {

            max = Math.max(max, num);
            min = Math.min(min, num);
            return;
        }

        if (op[0] != 0) {
            op[0]--;
            DFS(cnt + 1, num + src[cnt + 1]);
            op[0]++;
        }
        if (op[1] != 0) {
            op[1]--;
            DFS(cnt + 1, num - src[cnt + 1]);
            op[1]++;
        }
        if (op[2] != 0) {
            op[2]--;
            DFS(cnt + 1, num * src[cnt + 1]);
            op[2]++;
        }
        if (op[3] != 0) {
            op[3]--;
            if (num < 0) {
                num *= -1;
                DFS(cnt + 1, (num / src[cnt + 1]) * -1);
            } else
                DFS(cnt + 1, num / src[cnt + 1]);

            op[3]++;
        }


    }
}
