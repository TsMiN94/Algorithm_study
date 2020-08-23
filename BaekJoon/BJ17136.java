package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class BJ17136 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int arr[][] = new int[10][10];
    static int colorPaper[] = new int[6];
    static boolean visited[][] = new boolean[10][10];
    static int N, M;


    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 10; i++) {
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int j = 0; j < len; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }


        for (int i = 1; i <= 5; i++) {
            colorPaper[i] = 5;
        }

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (arr[i][j] == 1 && !visited[i][j])
                    BFS(i, j);
            }
        }
        int sum = 25;
        for (int i = 1; i < colorPaper.length; i++) {
            sum -= colorPaper[i];
        }
        if (answer < 0) {
            System.out.println(answer);
        } else {
            answer = sum;
            System.out.println(sum);
        }


    }

    //오른쪽 아래로  1 2 3 4 5 까지 가능한지 탐색
    private static void BFS(int r, int c) {
        int dx[] = {1, 0};
        int dy[] = {0, 1};
        //  System.out.println("현재 " + r + " , " + c);
        boolean flag = true;
        int nx = 0;
        int ny = 0;
        for (int i = 0; i < 2; i++) {
            nx = dx[i] + r;
            ny = dy[i] + c;
            if (nx >= 10 || ny >= 10 || visited[nx][ny] || arr[nx][ny] == 0) {
                flag = false;
                break;
            }
        }
        if (flag) {
            int cntX = 0, cntY = 0;
            int max = 1;
            int ty = c;
            int sizeYindex = 10, sizeY = 0;
            while (true) {
                if ( ty < 10 &&arr[r][ty] == 1 && !visited[r][ty]) {
                    cntY++;
                    if(cntY == 5) break;
                    ty++;
                } else {
                    break;
                }

            }

            for (int i = c, cnt = 0; i < c + cntY; i++, cnt++) {
                int len = r+ cntY -cnt;
                for (int j = r; j < len; j++) {
                    if (arr[j][i] == 0 || visited[j][i]) {
                        break;
                    }
                    cntX++;
                }
                boolean isColorPaper = true;
                if (cntX <= cntY - cnt) {

                    outer:
                    for (int k = r; k < r + cntX; k++) {
                        for (int s = i; s < i + cntX; s++) {
                            if (arr[k][s] == 0 || visited[k][s]) {
                                isColorPaper = false;
                                break outer;
                            }
                        }
                    }

                    if (isColorPaper) {
                        if (max < cntX) {
                            max = cntX;
                            sizeYindex = i;
                            //              System.out.println("sizeYindex = " + sizeYindex);
                        }
                    }
                }
                cntX = 0;
            }

            contactColorPaper(r, c, sizeYindex, max);

        } else {
            if (!visited[r][c]) {
                //   System.out.println("1색종이 감소");
                if (colorPaper[1] > 0) {
                    colorPaper[1]--;
                    visited[r][c] = true;
                    //   System.out.println(r + " , " + c + " 방문!");
                } else
                    answer = -1;
            }
        }


    }

    private static void contactColorPaper(int x, int c, int y, int sizeX) {
        //System.out.println(x + " , " + y + "  / " + sizeX);
        for (int i = x; i < x + sizeX; i++) {
            for (int j = y; j < y + sizeX; j++) {
                //         System.out.println(i + " , " + j + " 방문!");
                visited[i][j] = true;
            }
        }
        colorPaper[sizeX]--;
        BFS(x, c);
    }

}
