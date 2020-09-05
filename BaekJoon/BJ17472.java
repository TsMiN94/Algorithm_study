package BackJun;

import sun.corba.Bridge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17472 {
    static int N, M;
    static int answer = 0;
    static int map[][];
    static boolean visited[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static int section = 1;
    static int arr[];
    static PriorityQueue<Bridge> pq = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    BFS(i, j, section);
                    section++;
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] > 0)
                    putBridge(i, j);
            }
        }
        selectBridge();

        // System.out.println(answer);
    }

    private static void selectBridge() {
        arr = new int[section];

        for (int i = 1; i < section; i++) {
            arr[i] = i;
        }

        int size = pq.size();
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            Bridge b = pq.poll();

            int aArea = b.a;
            int bArea = b.b;
            if (union(aArea, bArea)) {
                answer += b.dist;
                cnt++;

            }
        }

        if (answer == 0 || (section - 2) != cnt) {
            System.out.println(-1);
        } else {
            System.out.println(answer);
        }

    }

    public static int findSet(int x) {
        if (arr[x] == x) return x;
        else
            return arr[x] = findSet(arr[x]);
    }

    public static boolean union(int x, int y) {
        x = findSet(x);
        y = findSet(y);
        if (x != y) {
            arr[y] = x;
            return true;
        } else
            return false;
    }


    private static void putBridge(int x, int y) {

        for (int i = 0; i < 4; i++) {
            int nx = x;
            int ny = y;
            int tx = 0, ty = 0;
            int cnt = 0;
            boolean flag = true;
            while (true) {

                tx = nx + dx[i];
                ty = ny + dy[i];
                if (tx < 0 || ty < 0 || tx >= N || ty >= M) {
                    flag = false;
                    break;
                }
                if (map[tx][ty] == 0) {
                    nx += dx[i];
                    ny += dy[i];
                    cnt++;
                } else if (map[tx][ty] != 0) {
                    nx += dx[i];
                    ny += dy[i];
                    break;
                }
            }
            if (cnt >= 2 && flag) {
                pq.add(new Bridge(map[x][y], map[nx][ny], cnt));
            }

        }
    }

    private static void BFS(int x, int y, int section) {
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));
        visited[x][y] = true;
        map[x][y] = section;
        while (!q.isEmpty()) {
            Point cur = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny] || map[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                map[nx][ny] = section;
                q.add(new Point(nx, ny));
            }
        }
    }

    public static class Bridge implements Comparable<Bridge> {
        int dist;
        int a, b;

        public Bridge(int a, int b, int dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public String toString() {
            return "Bridge{" +
                    "dist=" + dist +
                    ", a=" + a +
                    ", b=" + b +
                    '}';
        }

        @Override
        public int compareTo(Bridge o) {
            return Integer.compare(this.dist, o.dist);
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
