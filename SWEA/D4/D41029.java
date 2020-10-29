package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class D41029 {
    static int N;
    static int map[][], dist[][];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            map = new int[N][N];
            dist = new int[N][N];
            for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
            dist[0][0] = 0;
            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < N; j++) {
                    map[i][j] = str.charAt(j) - '0';
                }
            }
            recover(0, 0);

            System.out.println("#" + t + " " + dist[N - 1][N - 1]);
        }

    }

    private static void recover(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1};
        q.add(new Point(x, y));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (dist[nx][ny] > dist[cur.x][cur.y] + map[nx][ny]) {
                    dist[nx][ny] = dist[cur.x][cur.y] + map[nx][ny];
                    q.add(new Point(nx, ny));
                }

            }

        }


    }


    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
