package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_모의SW역량_숫자만들기 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int op[] = new int[4];
    static int numbers[];
    static int max, min;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = 0;
            max = Integer.MIN_VALUE;
            min = Integer.MAX_VALUE;
            N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            for (int i = 0; i < 4; i++) {
                op[i] = Integer.parseInt(st.nextToken());
            }

            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                numbers[i] = Integer.parseInt(st.nextToken());
            }


            DFS(1, numbers[0]);

            answer = max - min;
            System.out.println("#" + t + " " + answer);
        }
    }

    private static void DFS(int cnt, int sum) {

        if (cnt == N) {
            max = Math.max(sum, max);
            min = Math.min(sum, min);
            return;
        }
        for (int i = 0; i < 4; i++) {

            if (op[i] > 0) {
                op[i]--;
                if (i == 0) {
                    DFS(cnt + 1, sum + numbers[cnt] );
                } else if (i == 1) {
                    DFS(cnt + 1, sum - numbers[cnt] );
                } else if (i == 2) {
                    DFS(cnt + 1, sum * numbers[cnt] );
                } else {
                    DFS(cnt + 1, sum / numbers[cnt]);
                }
                op[i]++;
            }
        }

    }
}
