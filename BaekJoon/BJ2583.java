package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ2583 {
    static int arr[][];
    static int N, M, K;
    static boolean visited[][];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new int[M][N];

        visited = new boolean[M][N];

        for (int t = 0; t < K; t++) {
            st = new StringTokenizer(br.readLine());
            int startY = Integer.parseInt(st.nextToken());
            int startX = Integer.parseInt(st.nextToken());
            int offsetY = Integer.parseInt(st.nextToken());
            int offsetX = Integer.parseInt(st.nextToken());
            for (int i = startX; i < offsetX; i++) {
                for (int j = startY; j < offsetY; j++) {
                    arr[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (arr[i][j] == 0 && !visited[i][j]) {
                    BFS(i, j);
                }
            }
        }


        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
            //if (i + 1 < list.size()) System.out.print(" ");
        }

    }

    private static void BFS(int x, int y) {
        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, -1, 0, 1};
        int cnt = 1;
        Queue<Point> q = new LinkedList<>();
        q.add(new Point(x, y));

        visited[x][y] = true;
        while (!q.isEmpty()) {
            Point cur = q.poll();
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + cur.x;
                int ny = dy[i] + cur.y;
                if (nx < 0 || ny < 0 || nx >= M || ny >= N || visited[nx][ny] || arr[nx][ny] == 1) continue;
                q.add(new Point(nx, ny));
                visited[nx][ny] = true;
                cnt++;
            }
        }
        list.add(cnt);

    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
