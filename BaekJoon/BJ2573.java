package BackJun;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ2573 {
    static int map[][];
    static int N, M;
    static int answer = 0;
    static Queue<Glacier> glaciers = new LinkedList<>();
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static int cnt = 0;
    static int maxHeight = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());


        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp != 0) {
                    map[i][j] = temp;
                    if (temp > maxHeight)
                        maxHeight = temp;
                    glaciers.add(new Glacier(i, j, map[i][j]));
                    cnt++;
                }
            }
        }


        while (!glaciers.isEmpty()) {
            Glacier cur = glaciers.poll();
            if (map[cur.x][cur.y] != 0) {
                if (check(cur)) {
                    break;
                }
                melting();
                for (int t[] : map) System.out.println(Arrays.toString(t));
                System.out.println("====");
                answer++;
            }
            if (map[cur.x][cur.y] > 0)
                glaciers.add(cur);
        }
        if(cnt ==0)
            System.out.println(0);
        else
        System.out.println(answer);

    }

    private static boolean check(Glacier cur) {
        Queue<Glacier> q = new LinkedList<>();

        boolean[][] visited = new boolean[N][M];

        q.add(cur);
        visited[cur.x][cur.y] = true;
        int checkPoint = 0;
        while (!q.isEmpty()) {
            Glacier g = q.poll();
            checkPoint++;

            if (checkPoint == cnt) {
                return false;
            }
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + g.x;
                int ny = dy[i] + g.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 0 || visited[nx][ny]) continue;
                q.add(new Glacier(nx, ny, 0));
                visited[nx][ny] = true;
            }
        }
        return true;
    }

    private static void melting() {

        Queue<Glacier> q = new LinkedList<>();
        for (int t = 0; t < N; t++) {
            for (int j = 0; j < M; j++) {
                if (map[t][j] != 0) {
                    int sea = 0;
                    int nx = 0, ny = 0;
                    for (int i = 0; i < 4; i++) {
                        nx = dx[i] + t;
                        ny = dy[i] + j;
                        if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
                        if (map[nx][ny] == 0) {
                            sea++;
                        }
                    }
                    q.add(new Glacier(t, j, sea));
                }
            }
        }
        while (!q.isEmpty()) {
            Glacier g = q.poll();
            if (map[g.x][g.y] <= g.h) {
                map[g.x][g.y] = 0;
                cnt--;
            } else {
                map[g.x][g.y] -= g.h;
            }
        }

    }

    public static class Glacier {
        int x, y, h;

        public Glacier(int x, int y, int h) {
            this.x = x;
            this.y = y;
            this.h = h;
        }
    }
}
