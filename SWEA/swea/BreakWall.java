package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BreakWall {
    static int map[][];
    static int N, W, H;
    static int answer = Integer.MAX_VALUE;
    static int arr[], src[];
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        StringTokenizer st = null;


        for (int t = 1; t <= TC; ++t) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            arr = new int[N];
            src = new int[W];
            for (int i = 0; i < W; i++) {
                src[i] = i;
            }
            map = new int[H][W];

            for (int i = 0; i < H; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < W; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dropTheBall(0);
            System.out.println("#" + t + " " + answer);
            answer = Integer.MAX_VALUE;

        }
    }

    private static void dropTheBall(int cnt) {
        if (cnt == N ) {
            if(answer !=0)
                breakTheWall();
            return;
        }

        for (int i = 0; i < src.length; i++) {
            arr[cnt] = src[i];
            dropTheBall(cnt + 1);
        }
    }

    private static void breakTheWall() {

        int bx = 0, by = 0;
        int copy[][] = new int[H][W];
        for (int i = 0; i < H; i++)
            copy[i] = map[i].clone();

        for (int i = 0; i < arr.length; i++) {
            by = arr[i];
            for (int j = 0; j < H; j++) {
                if (copy[j][by] != 0) {
                    bx = j;
                    break;
                }
            }

             copy = chainBomb(bx, by, copy);

        }

        int cnt = 0;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                if (copy[i][j] > 0) cnt++;
            }
        }

        answer = Math.min(answer, cnt);
    }

    private static int[][] chainBomb(int x, int y, int[][] copy) {

        Queue<Wall> q = new LinkedList<>();
        q.add(new Wall(x, y, copy[x][y]));
        while (!q.isEmpty()) {

            Wall curWall = q.poll();
            int size = curWall.value;
            int cx = curWall.x, cy = curWall.y;
            copy[cx][cy] = 0;
            for (int i = 0; i < 4; i++) {
                for (int p = 1; p < size; p++) {
                    int nx = cx + dx[i] * p;
                    int ny = cy + dy[i] * p;
                    if (nx < 0 || ny < 0 || nx >= H || ny >= W || copy[nx][ny] == 0) continue;
                    q.add(new Wall(nx, ny, copy[nx][ny]));
                }
            }

        }

        for (int i = 0; i < W; i++)
            reValidate(copy, i);

        return copy;

    }

    private static void reValidate(int[][] copy, int y) {
        for (int x = H - 1; x >0; x--) {
            int temp;
            if (copy[x][y] == 0) {
                for (int nx = x - 1; nx >= 0; nx--) {
                    if (copy[nx][y] != 0) {
                        temp = copy[nx][y];
                        copy[x][y] = temp;
                        copy[nx][y] = 0;
                        break;
                    }
                }
            }
        }

    }

    public static class Wall {
        int x, y, value;

        public Wall(int x, int y, int value) {
            this.x = x;
            this.y = y;
            this.value = value;
        }

        @Override
        public String toString() {
            return "Wall{" +
                    "x=" + x +
                    ", y=" + y +
                    ", value=" + value +
                    '}';
        }
    }

}
