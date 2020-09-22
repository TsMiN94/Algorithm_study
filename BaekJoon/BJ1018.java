package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1018 {
    static char map[][];
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < r - 7; i++) {
            for (int j = 0; j < c - 7; j++) {
                int cnt = check(i, j);
                answer = Math.min(answer, cnt);
            }
        }
        System.out.println(answer);
    }

    private static int check(int sx, int sy) {
        int cntF = 0;
        int cntS = 1;
        char firstColor = map[sx][sy];
        char secondColor;
        if (firstColor == 'B') {
            secondColor = 'W';
        } else {
            secondColor = 'B';
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 0) continue;
                int ny = sy + j;
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (map[sx + i][ny] != firstColor) cntF++;
                    } else {
                        if (map[sx + i][ny] == firstColor) cntF++;
                    }
                } else {
                    if (j % 2 == 0) {
                        if (map[sx + i][ny] == firstColor) cntF++;
                    } else {
                        if (map[sx + i][ny] != firstColor) cntF++;
                    }
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (i == 0 && j == 0) continue;
                int ny = sy + j;
                if (i % 2 == 0) {
                    if (j % 2 == 0) {
                        if (map[sx + i][ny] != secondColor) cntS++;
                    } else {
                        if (map[sx + i][ny] == secondColor) cntS++;
                    }
                } else {
                    if (j % 2 == 0) {
                        if (map[sx + i][ny] == secondColor) cntS++;
                    } else {
                        if (map[sx + i][ny] != secondColor) cntS++;
                    }
                }
            }
        }

        return Math.min(cntF, cntS);
    }
}
