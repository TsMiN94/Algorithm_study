package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ1182 {
    static int N, S;
    static int arr[];
    static boolean selected[];
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        subSet(0);
        System.out.println(answer);
    }

    private static void subSet(int cnt) {
        if (cnt == N) {
            int sum = 0;
            int temp = Integer.MIN_VALUE;
            int selectCnt = 0;
            for (int i = 0; i < N; i++) {
                if (selected[i]) {
                    selectCnt++;
                    sum += arr[i];
                }
            }
            if (sum == S && selectCnt != 0) answer++;

            return;
        }

        selected[cnt] = true;
        subSet(cnt + 1);
        selected[cnt] = false;
        subSet(cnt + 1);

    }
}