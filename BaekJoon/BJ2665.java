package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ2665 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int map[][];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1,};
        int memo[][] = new int[N][N];
        for (int i = 0; i < N; i++) Arrays.fill(memo[i], Integer.MAX_VALUE);

        Queue<Point> q = new LinkedList<>();
        if (map[0][0] == 0) memo[0][0] = 1;
        else
            memo[0][0] = 0;
        q.add(new Point(0, 0, 0));
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (map[nx][ny] == 0) {
                    if (memo[nx][ny] > cur.cnt + 1) {
                        memo[nx][ny] = cur.cnt + 1;
                        q.add(new Point(nx, ny, memo[nx][ny]));
                    }
                } else {
                    if (memo[nx][ny] > cur.cnt) {
                        memo[nx][ny] = cur.cnt;
                        q.add(new Point(nx, ny, memo[cur.x][cur.y]));
                    }
                }
            }
        }
//        for (int i = 0; i < N; i++)
//            System.out.println(Arrays.toString(memo[i]));

        System.out.println(memo[N - 1][N - 1]);
    }

    public static class Point {
        int x, y, cnt;

        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
