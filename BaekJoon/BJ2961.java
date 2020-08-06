package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ2961 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] foods;
    static boolean selected[];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        long S = 0, B = 0;
        foods = new int[N][2];
        selected = new boolean[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            foods[i][0] = Integer.parseInt(st.nextToken());
            foods[i][1] = Integer.parseInt(st.nextToken());

        }

        subSet(0);
        System.out.println(answer);
    }

    static void subSet(int cnt) {
        if (cnt >= 1) {
            int S_MUL = 1, B_SUM = 0;
            boolean flag =false;
            for (int i = 0; i < selected.length; i++) {
                if (selected[i]) {
                    S_MUL = S_MUL * foods[i][0];
                    B_SUM = B_SUM + foods[i][1];
                    flag = true;
                }
            }
            if(flag)
                answer = Math.min(answer, Math.abs(S_MUL - B_SUM));
            if(cnt == foods.length)return;
        }

        // 부분집합 구성에 포함
        selected[cnt] = true;
        subSet(cnt + 1);
        // 부분집합 구성에 미포함
        selected[cnt] = false;
        subSet(cnt + 1);
    }


}
