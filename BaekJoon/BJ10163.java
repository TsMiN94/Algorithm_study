package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ10163 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int map[][] = new int[101][101];
        Square squares[] = new Square[N];
        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            squares[i - 1] = new Square(x1, w, y1, h);
            for (int r = x1; r < x1+w; r++) {
                for (int c = y1; c < y1+h; c++) {
                        map[r][c] = i;
                }
            }
        }
        //for(int t[]: map)System.out.println(Arrays.toString(t));

        for (int i = 0; i < N; i++) {
            int answer = 0;
            int x1 = squares[i].x1;
            int w = squares[i].w;
            int y1 = squares[i].y1;
            int h = squares[i].h;
            for (int r = x1; r < x1+w; r++) {
                for (int c = y1; c < y1+h; c++) {
                    if (map[r][c] == i + 1) {
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }

    }

    public static class Square {
        int x1, w, y1, h;

        public Square(int x1, int w, int y1, int h) {
            this.x1 = x1;
            this.w = w;
            this.y1 = y1;
            this.h = h;
        }
    }
}
