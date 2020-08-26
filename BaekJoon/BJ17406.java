package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ17406 {
    static int N, M, K;
    static int map[][];
    static RotateInfo[] src;
    static RotateInfo[] arr;
    static boolean visited[];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        src = new RotateInfo[K];
        arr = new RotateInfo[K];
        visited = new boolean[K];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            src[i] = new RotateInfo(r, c, s);
        }
        perm(0);
        System.out.println(answer);
    }

    private static void perm(int cnt) {
        if (cnt == K) {
            int cloneArr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                cloneArr[i] = map[i].clone();
            }

            for (int i = 0; i < arr.length; i++) {
                RotateInfo rotateInfo = arr[i];
                int r = rotateInfo.r;
                int c = rotateInfo.c;
                int s = rotateInfo.s;
                rotate(r - 1, c - 1, s, cloneArr);
            }
            int min = calc(cloneArr);
            answer = Math.min(min, answer);
            return;
        }

        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = src[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }
    }

    private static int calc(int[][] cloneArr) {

        System.out.println("==============");
        for (int t[] : cloneArr) {
            System.out.println(Arrays.toString(t));
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += cloneArr[i][j];
            }
            min = Math.min(sum, min);
        }
        return min;
    }

    private static void rotate(int r, int c, int s, int[][] cloneArr) {

        for (int i = s; i > 0; i--) {
            int sx = r - i;
            int ex = r + i;

            int sy = c - i;
            int ey = c + i;

            int nextValue = 0;
            int curValue = cloneArr[sx][sy];
            for (int y = sy; y < ey; y++) {
                if (y + 1 <= ey) {
                    nextValue = cloneArr[sx][y + 1];
                    cloneArr[sx][y + 1] = curValue;
                    curValue = nextValue;

                }
            }

            for (int x = sx; x < ex; x++) {
                if (x + 1 <= ex) {
                    nextValue = cloneArr[x + 1][ey];
                    cloneArr[x + 1][ey] = curValue;
                    curValue = nextValue;
                }
            }
            for (int y = ey; y > 0; y--) {
                if (y - 1 >= sy) {
                    nextValue = cloneArr[ex][y - 1];
                    cloneArr[ex][y - 1] = curValue;
                    curValue = nextValue;
                }
            }
            for (int x = ex; x > 0; x--) {
                if (x - 1 >= sx) {
                    nextValue = cloneArr[x - 1][sy];
                    cloneArr[x - 1][sy] = curValue;
                    curValue = nextValue;
                }
            }

        }


    }

    static public class RotateInfo {
        int r, c, s;

        public RotateInfo(int r, int c, int s) {
            this.r = r;
            this.c = c;
            this.s = s;
        }


    }

}
