package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BJ10026 {
    static char[][] map;
    static int N;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int A = 0, B = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new char[N][N];
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        boolean[][] visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    check(i, j, visited);
                    A++;
                }
            }
        }
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    checkB(i, j, visited);
                    B++;
                }
            }
        }


        System.out.println(A + " " + B);
    }

    private static void check(int x, int y, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y, map[x][y]));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny] || cur.col != map[nx][ny]) continue;

                q.add(new Point(nx, ny, map[nx][ny]));
                visited[nx][ny] = true;
            }
        }
    }

    private static void checkB(int x, int y, boolean[][] visited) {
        Queue<Point> q = new LinkedList<>();

        q.add(new Point(x, y, map[x][y]));
        visited[x][y] = true;

        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                if (cur.col == 'R' || cur.col == 'G') {
                    if (map[nx][ny] == 'R' || map[nx][ny] == 'G') {
                        map[nx][ny] = cur.col;
                        q.add(new Point(nx, ny, map[nx][ny]));
                        visited[nx][ny] = true;
                    }
                } else {
                    if (map[nx][ny] == 'R' || map[nx][ny] == 'G') continue;
                    else {
                        q.add(new Point(nx, ny, map[nx][ny]));
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }

    public static class Point {
        int x, y;
        char col;

        public Point(int x, int y, char col) {
            this.x = x;
            this.y = y;
            this.col = col;
        }
    }
}
