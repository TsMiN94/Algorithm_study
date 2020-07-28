package SWEA_D2;

import java.util.Scanner;

public class DalpangE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for(int test_case = 1; test_case <= T; test_case++){
            int N = sc.nextInt();
            int[][] map = new int[N][N];

            int offset = 1;
            int x = 0, y = -1;
            int cnt = 1;

            while(true) {
                for(int i = 0; i < N; i++) {
                    y = y + offset;
                    map[x][y] = cnt;
                    cnt++;
                }
                N--;
                for(int i = 0; i < N; i++) {
                    x = x + offset;
                    map[x][y] = cnt;
                    cnt++;
                }
                offset *= -1;
                if(N == 0)
                    break;
            }
            System.out.println("#" + test_case);

            for(int i = 0; i < map.length; i++) {
                for(int j = 0; j < map.length; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
