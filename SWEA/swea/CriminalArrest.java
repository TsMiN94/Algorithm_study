package SWEA;

import javax.management.loading.MLet;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class CriminalArrest {
    static int answer = 0;
    static int N, M, R, C, L;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
    static int direction[][] = {
            {0, 0, 0, 0},
            {1, 1, 1, 1},
            {1, 0, 1, 0},
            {0, 1, 0, 1},
            {1, 1, 0, 0},
            {0, 1, 1, 0},
            {0, 0, 1, 1},
            {1, 0, 0, 1}
    };
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int testcase = 1; testcase <= TC; testcase++) {
            answer = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            map = new int[N][M];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < M; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            BFS(R, C);

            System.out.println("#" + testcase + " " + answer);
        }
    }

    private static void BFS(int sx, int sy) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(sx, sy, map[sx][sy]));
        boolean[][] visited = new boolean[N][M];
        visited[sx][sy] = true;
        int time = 0;
        while (!q.isEmpty()) {
            if (time == L-1) break;

            int size = q.size();
            while (size-- > 0) {
                Point cur = q.poll();
                int dir[] = direction[cur.type];
                for (int i = 0; i < 4; i++) {
                    if (dir[i] == 0) continue;
                    int nx = cur.x + dx[i];
                    int ny = cur.y + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;

                    if (direction[map[nx][ny]][(i + 2) % 4] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Point(nx, ny, map[nx][ny]));
                        answer++;
                    }

                }
            }
            time++;
        }

    }

    public static class Point {
        int x, y, type;

        public Point(int x, int y, int type) {
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
}
