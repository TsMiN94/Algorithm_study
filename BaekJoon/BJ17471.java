package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BJ17471 {
    static int N;
    static int popular[];

    static boolean connect[][];
    static int areaArr[];
    static int answer = Integer.MAX_VALUE, sum = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        popular = new int[N];

        connect = new boolean[N][N];
        areaArr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            popular[i] = Integer.parseInt(st.nextToken());
            sum += popular[i];

        }
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            for (int j = 0; j < s; j++) {
                int to = Integer.parseInt(st.nextToken()) - 1;
                connect[i][to] = true;
            }
        }

        subSet(0);
        if (answer == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else
            System.out.println(answer);
    }


    private static void subSet(int cnt) {

        if (cnt == N) {
            int a = 0, b = 0;
            for (int i = 0; i < N; i++) {
                if (areaArr[i] == 1) {
                    a += popular[i];
                } else {
                    b += popular[i];
                }
            }
            int section = 0;
            boolean[] visited = new boolean[N];
            for (int i = 0; i < N; i++) {
                if (!visited[i]) {
                    connection(i, visited);
                    section++;
                }
            }
            if (section == 2) {
                answer = Math.min(Math.abs(a - b), answer);
            }

            return;
        }
        areaArr[cnt] = 1;
        subSet(cnt + 1);
        areaArr[cnt] = 2;
        subSet(cnt + 1);

    }

    private static void connection(int v, boolean[] visited) {
        visited[v] = true;
        for (int i = 0; i < N; i++) {
            if (!visited[i] && connect[v][i] && areaArr[v] == areaArr[i]) {
                connection(i, visited);
            }
        }
    }


}


