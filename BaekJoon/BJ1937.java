package BackJun;

import java.io.*;
import java.util.*;

public class BJ1937 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int map[][];
    static int memo[][];
    static boolean visited[][];
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        memo = new int[N][N];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer = Math.max(answer, DFS(i, j));
            }
        }

        out.write(String.valueOf(answer));
        out.close();
        br.close();
    }

    public static class Point {
        int value, index;

        public Point(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    private static int DFS(int x, int y) {
        if (memo[x][y] > 0) return memo[x][y];
        int max = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
            if (map[nx][ny] <= map[x][y]) continue;
            max = Math.max(DFS(nx, ny), max);
        }
        return memo[x][y] += max + 1;
    }
}

