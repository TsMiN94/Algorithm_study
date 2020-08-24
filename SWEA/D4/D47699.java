package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class D47699 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, M;
    static char arr[][];
    static boolean visitied[][];
    static int answer = 0;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case <= T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            arr = new char[N][M];
            visitied = new boolean[N][M];

            for (int i = 0; i < N; i++) {
                String str = br.readLine();
                for (int j = 0; j < str.length(); j++) {
                    arr[i][j] = str.charAt(j);
                }
            }
            String temp = arr[0][0]+"";
            DFS(0, 0, temp, 1);
            System.out.println("#" + test_case + " " + answer);
            answer = 0;

        }
    }

    private static void DFS(int x, int y, String str, int cnt) {

        if (answer < cnt) {
            answer = cnt;
        }
        if (cnt == 26) return;


        int dx[] = {1, 0, -1, 0};
        int dy[] = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            int nx = dx[i] + x;
            int ny = dy[i] + y;
            if (nx < 0 || ny < 0 || nx >= N || ny >= M || visitied[nx][ny]) continue;

            if (!str.contains(arr[nx][ny] + "")) {
                visitied[x][y] = true;
                String temp  = str +  arr[nx][ny];
                DFS(nx, ny, temp, cnt+1);

                visitied[x][y] = false;
            }
        }
    }
}
