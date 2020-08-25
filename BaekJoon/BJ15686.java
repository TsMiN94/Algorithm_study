package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ15686 {
    static int N, M;
    static int arr[][];
    static ArrayList<Point> house = new ArrayList<>();
    static ArrayList<Point> chicken = new ArrayList<>();
    static Point[] ch;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];
        ch = new Point[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 1)
                    house.add(new Point(i, j));
                else if (arr[i][j] == 2) {
                    chicken.add(new Point(i, j));
                }
            }
        }
        comb(0, 0);
        System.out.println(answer);
    }

    private static void comb(int cnt, int start) {
        if (cnt == M) {

            int sum = 0;
            for (Point h : house) {
                int min = Integer.MAX_VALUE;
                for (int i = 0; i < ch.length; i++) {
                    Point c = ch[i];
                    int dist = Math.abs(h.x - c.x) + Math.abs(h.y - c.y);

                    min = Math.min(min, dist);
                }

                sum += min;

            }
            answer = Math.min(sum, answer);
            return;
        }
        for (int i = start; i < chicken.size(); i++) {
            ch[cnt] = chicken.get(i);
            comb(cnt + 1, i + 1);
        }

    }


    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

}
