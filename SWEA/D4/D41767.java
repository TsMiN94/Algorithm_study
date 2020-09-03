package SWEA_D4;

import java.io.*;
import java.util.*;

public class D41767 {
    static int N, max, min, totalCnt, map[][];
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static ArrayList<int[]> list;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder answer = new StringBuilder();
        int T = Integer.parseInt(in.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(in.readLine());
            map = new int[N][N];
            list = new ArrayList<int[]>();
            max = 0;
            min = Integer.MAX_VALUE;
            totalCnt = 0;

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(in.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if ((i == 0 || i == N - 1 || j == 0 || j == N - 1) && map[i][j] == 1)
                        continue;

                    if (map[i][j] == 1) {
                        list.add(new int[]{i, j});
                        totalCnt++;
                    }
                }
            }
            setLine(0, 0);
            System.out.println("#" + t + " " + min);
        }
        System.out.print(answer);

    }


    private static void setLine(int index, int coreCnt) {
        if (totalCnt - index + coreCnt < max) return;

        int res = getLength();
        if (max < coreCnt) {
            max = coreCnt;
            min = res;
        } else if (max == coreCnt) {
            if (min > res)
                min = res;
        }

        for (int i = index; i < totalCnt; i++) {
            int[] cur = list.get(i);
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {

                if (isAvailable(x, y, d)) {
                    setStatus(x, y, d, 2);
                    setLine(i + 1, coreCnt + 1);
                    setStatus(x, y, d, 0);
                }
            }
        }
    }

    private static boolean isAvailable(int x, int y, int d) {
        int nx = x, ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                break;

            if (map[nx][ny] >= 1)
                return false;
        }
        return true;
    }

    private static void setStatus(int x, int y, int d, int s) {
        int nx = x, ny = y;

        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                break;

            map[nx][ny] = s;
        }
    }

    private static int getLength() {
        int lCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == 2)
                    lCnt++;
            }
        }
        return lCnt;
    }


}
