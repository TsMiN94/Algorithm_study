package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1520 {
    static int M, N;
    static int map[][], dp[][];
    static int answer = 0;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    static int endValue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        dp = new int[N][M];
        for (int i = 0; i < N; i++) Arrays.fill(dp[i], -1);
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        endValue = map[N - 1][M - 1];

        DFS(0, 0);
     
        System.out.println(dp[0][0]);
    }

    private static int DFS(int x, int y) {

        if (x == N - 1 && y == M - 1) {
            return 1;
        }

        if (dp[x][y] > 0) {
            return dp[x][y];
        }
        if (dp[x][y] == -1) {
            dp[x][y] = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= N || nx < 0 || ny < 0 || ny >= M || map[x][y] <= map[nx][ny] || map[x][y] <= endValue)
                    continue;
                dp[x][y] += DFS(nx, ny);
            }
        }

        return dp[x][y];
    }
}
