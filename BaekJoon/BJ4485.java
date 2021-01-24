package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ4485 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int map[][];
    static int n;

    public static void main(String[] args) throws IOException {
        String str;
        int t = 1;
        while ((str = br.readLine().trim()) != null) {
            n = Integer.parseInt(str);
            if(n == 0) break;
            answer = 0;
            map = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS(0, 0);
            System.out.println("Problem " + t + ": " + answer);
            t++;
        }
    }

    private static void BFS(int x, int y) {
        int dx[] = {1, -1, 0, 0};
        int dy[] = {0, 0, 1, -1,};

        int memo[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], Integer.MAX_VALUE);
        }
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y, map[x][y]));
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
                if (memo[nx][ny] > cur.val + map[nx][ny]) {
                    memo[nx][ny] = cur.val + map[nx][ny];
                    q.add(new Point(nx, ny, memo[nx][ny]));
                }
            }
        }

        answer = memo[n - 1][n - 1];
    }

    public static class Point {
        int x, y, val;

        public Point(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }
}
