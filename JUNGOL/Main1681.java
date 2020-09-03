package JO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


import java.util.StringTokenizer;

public class Main1681 {
    static int N;

    static int answer = Integer.MAX_VALUE;
    static int graph[][];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        graph = new int[N][N];
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int cost = Integer.parseInt(st.nextToken());
                graph[i][j] = cost;
            }
        }

        delivery(0, 0, 0);

        System.out.println(answer);
    }

    private static void delivery(int v, int sum, int cnt) {
        if (cnt == N-1) {
            if (graph[v][0] != 0) {
                answer = Math.min(answer, sum + graph[v][0]);
            }
            return;
        }

        for (int i = 1; i < N; i++) {
            if (!visited[i] && graph[v][i] != 0 && answer > sum + graph[v][i]) {
                visited[i] = true;
                delivery(i, sum + graph[v][i], cnt + 1);
                visited[i] = false;
            }
        }
    }


}



