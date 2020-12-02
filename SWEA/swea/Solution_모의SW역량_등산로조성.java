package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Solution_모의SW역량_등산로조성 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, K;
    static int map[][];
    static int dx[] = {1, 0, -1, 0};
    static int dy[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            int maxValue = 0;
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if (map[i][j] > maxValue) maxValue = map[i][j];
                }
            }


            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] == maxValue) {
                        DFS(i, j, 1, map[i][j], new boolean[N][N], 0);
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void DFS(int x, int y, int cnt, int cur, boolean[][] visited, int cut) {
//        System.out.print(x + " / " + y + " 좌표의 현재 값" + cur + " ");
//        System.out.println("cnt =" + cnt);

        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;

            if (map[nx][ny] < cur) {
                visited[x][y] = true;
                DFS(nx, ny, cnt + 1, map[nx][ny], visited, cut);
                visited[x][y] = false;
            }

            if (map[nx][ny] >= cur && cut == 0) {
                for (int kk = 1; kk <= K; kk++) {
                    if (map[nx][ny] - kk < cur) {
                        int temp;
                        if (map[nx][ny] - K < 0) temp = 0;
                        else {
                            temp = map[nx][ny] -kk;
                        }
                        visited[x][y] = true;
                        cut = 1;
                        DFS(nx, ny, cnt + 1, temp, visited, cut);
                        cut = 0;
                        visited[x][y] = false;
                    }

                }
            }


        }

        answer = Math.max(cnt, answer);
    }

}
