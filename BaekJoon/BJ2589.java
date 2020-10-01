package BackJun;

import java.io.*;
import java.util.*;


public class BJ2589 {
    static char map[][];
    static int memo[][];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int r, c;
    static int answer = 0;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][c];

        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (map[i][j] == 'L') {
                    answer = Math.max(BFS(i, j), answer);
                }
            }
        }

        System.out.println(answer);
    }

    private static int BFS(int x, int y) {
        Queue<Point> q = new LinkedList<>();
        boolean visited[][] = new boolean[r][c];
        q.add(new Point(x, y, 0));
        memo = new int[r][c];

        while (!q.isEmpty()) {
            Point cur = q.poll();

            answer = Math.max(answer, cur.cost);
            visited[cur.x][cur.y] = true;
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= r || ny >= c ||
                        map[nx][ny] == 'W' || visited[nx][ny])
                    continue;

                if (memo[nx][ny] < cur.cost + 1) {
                    memo[nx][ny] = cur.cost + 1;
                    q.add(new Point(nx, ny, cur.cost + 1));
                }
            }
        }

        return answer;
    }

    public static class Point {
        int x, y, cost;

        public Point(int x, int y, int cost) {
            super();
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", cost=" + cost +
                    '}';
        }
    }
}
