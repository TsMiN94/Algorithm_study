package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1012 {
    static StringTokenizer st;
    static int arr[][];
    static int N, M;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            arr = new int[N][M];
            for (int j = 0; j < K; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr[x][y] = 1;
            }


            visited = new boolean[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if(!visited[j][k] && arr[j][k]==1) {
                        DFS(j, k);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
            answer = 0;
        }
    }

    private static void DFS(int x, int y) {
        visited[x][y] = true;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        for (int i = 0; i < 4; i++) {

            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) {
                continue;
            }

            if (arr[nx][ny] == 0 || visited[nx][ny]) {
                continue;
            }
            DFS(nx, ny);
        }
    }
}
