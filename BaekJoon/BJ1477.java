package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ1477 {
    static int R, C;
    static char map[][];
    static Point start;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static Queue<Point> water = new LinkedList<>();
    static int answer = 0;
    static boolean visited[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                if (str.charAt(j) == 'S') {
                    start = new Point(i, j, 0);
                } else if (str.charAt(j) == '*') {
                    water.add(new Point(i, j, 0));
                }
                map[i][j] = str.charAt(j);
            }
        }

        if (escape(start.x, start.y)) {
            System.out.println(answer);
        } else
            System.out.println("KAKTUS");


    }

    private static boolean escape(int x, int y) {
        visited[x][y] = true;
        Queue<Point> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {


            int waterSize = water.size();
            while (waterSize > 0) {
                Point w = water.poll();
                for (int i = 0; i < 4; i++) {
                    int wx = w.x + dx[i];
                    int wy = w.y + dy[i];
                    if (wx < 0 || wy < 0 || wx >= R || wy >= C || map[wx][wy] == '*' || map[wx][wy] == 'X' || map[wx][wy] == 'D')
                        continue;
                    map[wx][wy] = '*';
                    water.add(new Point(wx, wy, 0));
                }
                waterSize--;
            }

            int dochiSize = q.size();
            while (dochiSize > 0) {
                Point cur = q.poll();
                if (map[cur.x][cur.y] == 'D') {
                    answer = cur.t;
                    return true;
                }
                map[cur.x][cur.y] = 'S';
                for (int i = 0; i < 4; i++) {
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == 'X' || map[nx][ny] == '*' || visited[nx][ny])
                        continue;
                    q.add(new Point(nx, ny, cur.t + 1));
                    visited[nx][ny] = true;
                }
                dochiSize--;
            }


        }


        return false;
    }

    public static class Point {
        int x, y, t;

        public Point(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
}
