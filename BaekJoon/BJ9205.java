package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ9205 {
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        map = new int[102][102];

        ArrayList<Point> list = new ArrayList<>();
        for (int t = 0; t < N; t++) {
            int storeCnt = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int max = storeCnt + 2;
            for (int i = 0; i < max; i++) {
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                list.add(new Point(x, y));
            }

            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j++) {
                    if (i == j) map[i][j] = 0;
                    map[i][j] = Integer.MAX_VALUE;
                }

            }
            for (int i = 0; i < max; i++) {
                for (int j = 0; j < max; j ++) {
                    if (i == j) continue;
                    Point from = list.get(i);
                    Point to = list.get(j);

                    int dist = Math.abs(from.x - to.x) + Math.abs(from.y - to.y);

                    if (dist <= 1000) {
                        map[i][j] = 1;
                    }
                }
            }

            for(int k=0; k<N; ++k) {
                for (int i = 0; i < N; ++i) {
                    if (i == k) continue; // 출발지와 경유지가 같다면 다음 출발지
                    for (int j = 0; j < N; ++j) {
                        if (i == j || k == j) continue; // 경유지와 목적지가 같거나 출발지가 곧 목적지라면 패스
                        if (map[i][k] + map[k][j] < map[i][j]) {
                            map[i][j] = map[i][k] + map[k][j];
                        }
                    }
                }
            }


            System.out.println();

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
