package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ13460 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static char arr[][];
    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new char[N][M];
        int rx = 0, ry = 0, bx = 0, by = 0, C = 0, R = 0;
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < str.length(); j++) {
                arr[i][j] = str.charAt(j);
                if (arr[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (arr[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if (arr[i][j] == 'O') {
                    R = i;
                    C = j;
                }
            }
        }
        int answer = bfs(rx, ry, bx, by, R, C);

        if (answer > 10) {
            System.out.println("-1");
        } else {
            System.out.println(answer);
        }

    }

    private static int bfs(int rx, int ry, int bx, int by, int r, int c) {
        Queue<Ball> q = new LinkedList<>();
        boolean redVisited[][] = new boolean[N][M];

        q.add(new Ball(rx, ry, 'R', 0));
        q.add(new Ball(bx, by, 'B', 0));
        redVisited[rx][ry] = true;

        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};

        Ball red, blue;
        while (!q.isEmpty()) {
            red = q.poll();
            blue = q.poll();

            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + red.x;
                int ny = dy[i] + red.y;
                int tx = blue.x;
                int ty = blue.y;

                if (nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == '#') continue;

            }
        }


        return -1;
    }

    public static class Ball {
        int x, y;
        char color;
        int cnt = 0;

        public Ball(int x, int y, char color, int cnt) {
            this.x = x;
            this.y = y;
            this.color = color;
            this.cnt = cnt;
        }
    }

}
