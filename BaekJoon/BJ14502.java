package BackJun;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14502 {
    static int map[][];
    static int N, M;
    static int wall = 3;
    static List<Point> birus = new ArrayList<>();
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    birus.add(new Point(i, j));
                }
            }
        }
        int clone[][] = new int[N][M];
        for (int i = 0; i < N; i++)
            clone[i] = map[i].clone();


        setWall(0, 0, clone);

        System.out.println(answer);
    }

    private static void setWall(int cnt, int start, int[][] clone) {
        if (cnt == 3) {
            int safeZone = 0;
            int m[][] = new int[N][M];
            for (int i = 0; i < N; i++)
                m[i] = clone[i].clone();

            Queue<Point> q = new LinkedList<>();
            for (int i = 0; i < birus.size(); i++) {
                Point p = birus.get(i);
                q.add(new Point(p.x, p.y));
            }

            while (!q.isEmpty()) {
                Point b = q.poll();

                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + b.x;
                    int ny = dy[i] + b.y;
                    if (nx < 0 || ny < 0 || nx >= N || ny >= M || m[nx][ny] == 2 || m[nx][ny] == 1) continue;
                    m[nx][ny] = 2;
                    q.add(new Point(nx, ny));
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (m[i][j] == 0) safeZone++;
                }
            }
            answer = Math.max(answer, safeZone);

            return;
        }
        for (int i = start; i < N * M; i++) {
            int row = i / M;
            int col = i % M;
            System.out.println(i + " , " + row+  " , "+ col );
            if (clone[row][col] == 0) {
                clone[row][col] = 1;
                setWall(cnt + 1, i + 1, clone);
                clone[row][col] = 0;
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
