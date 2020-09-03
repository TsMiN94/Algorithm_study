package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ17144 {
    static int map[][];
    static int R, C, T;

    static int cleaner[] = new int[2];
    static int dust = 0;
    static Queue<Point> q = new LinkedList<>();
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        int idx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    cleaner[idx] = i;
                    idx++;
                } else if (map[i][j] > 0) {
                    dust += map[i][j];
                    q.add(new Point(i, j, map[i][j]));
                }
            }
        }

        cleanStart();
        System.out.println(dust);
    }

    private static void cleanStart() {
        for (int t = 0; t < T; t++) {
            diffusion();
//            System.out.println((t + 1) + " 번째");
//            System.out.println("확장 후");
//            for (int y[] : map) {
//                System.out.println(Arrays.toString(y));
//            }
            move();
//            System.out.println("청정기 한번 이동 후");
//            for (int y[] : map) {
//                System.out.println(Arrays.toString(y));
//            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (map[i][j] >= 5) {
                        q.add(new Point(i, j, map[i][j]));
                    }
                }
            }
           // System.out.println("현재 먼지양 = " + dust);
        }
    }

    private static void diffusion() {

        while (!q.isEmpty()) {
            Point cur = q.poll();
            int cnt = 0;
            int d = cur.amount / 5;
            for (int j = 0; j < 4; j++) {
                int nx = dx[j] + cur.x;
                int ny = dy[j] + cur.y;
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
                map[nx][ny] += d;
                cnt++;
            }
            map[cur.x][cur.y] = map[cur.x][cur.y] - (d * cnt);
        }


    }

    private static void move() {
        int sx, ex, sy, ey;

        sx = cleaner[0];
        ex = 0;
        sy = 1;
        ey = C - 1;

        int nextValue = 0;
        int curValue = map[sx][sy];
        map[sx][sy] = 0;
        for (int y = sy; y < ey; y++) {
            if (y + 1 <= ey) {
                nextValue = map[sx][y + 1];
                map[sx][y + 1] = curValue;
                curValue = nextValue;
            }
        }
        for (int x = sx; x > 0; x--) {
            if (x - 1 >= ex) {
                nextValue = map[x - 1][ey];
                map[x - 1][ey] = curValue;
                curValue = nextValue;
            }
        }
        for (int y = ey; y > 0; y--) {
            if (y - 1 >= 0) {
                nextValue = map[ex][y - 1];
                map[ex][y - 1] = curValue;
                curValue = nextValue;
            }
        }
        for (int x = ex; x < sx; x++) {
            if (x + 1 <= sx) {
                nextValue = map[x + 1][0];
                if (map[x + 1][0] == -1) {
                    dust -= curValue;
                } else {
                    map[x + 1][0] = curValue;
                    curValue = nextValue;
                }
            }
        }


        sx = cleaner[1];
        ex = R - 1;
        sy = 1;
        ey = C - 1;

        nextValue = 0;
        curValue = map[sx][sy];
        map[sx][sy] = 0;
        for (int y = sy; y < ey; y++) {
            if (y + 1 <= ey) {
                nextValue = map[sx][y + 1];
                map[sx][y + 1] = curValue;
                curValue = nextValue;
            }
        }
        for (int x = sx; x < ex; x++) {
            if (x + 1 <= ex) {
                nextValue = map[x + 1][ey];
                map[x + 1][ey] = curValue;
                curValue = nextValue;
            }
        }
        for (int y = ey; y > 0; y--) {
            if (y - 1 >= 0) {
                nextValue = map[ex][y - 1];
                map[ex][y - 1] = curValue;
                curValue = nextValue;
            }
        }
        for (int x = ex; x > 0; x--) {
            if (x - 1 >= sx) {
                nextValue = map[x - 1][0];
                if (map[x - 1][0] == -1) {
                    dust -= curValue;
                } else {
                    map[x - 1][0] = curValue;
                    curValue = nextValue;
                }
            }
        }

    }


    static class Point {
        int x, y, amount;

        public Point(int x, int y, int i) {
            this.x = x;
            this.y = y;
            this.amount = i;
        }
    }

}
