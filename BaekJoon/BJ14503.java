package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14503 {
    static int map[][];
    static int N, M;
    static int answer = 0;
    static int dx[] = {-1, 1, 0, 0};
    static int dy[] = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int dir = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1)
                    map[i][j] = -1;
            }
        }

        clean(r, c, dir);
        for (int t[] : map) System.out.println(Arrays.toString(t));
        System.out.println(answer);
    }

    private static void clean(int r, int c, int dir) {
        int x = r;
        int y = c;
        answer = 1;
        int cnt = 0;
        while (true) {
            map[x][y] = 1;
            int nx = x, ny = y;

            boolean canClean = false;
            for (int i = 0; i < 4; i++) {
                int nextX = x + dx[i];
                int nextY = y + dy[i];
                System.out.println(i+"번째 nx = "+ nextX + " ny = "+nextY+" /"+isIn(nextX, nextY)+" ,"+ map[nextX][nextY]);
                if (isIn(nextX, nextY) && map[nextX][nextY] == 0) {
                    canClean = true;
                    break;
                }
            }
            if (!canClean) {
                System.out.println("cleaner can't clean anywhere so it should be turn back...");
                if (canBack(x, y, dir)) {
                    if (dir == 0) {
                        x++;
                    } else if (dir == 1) {
                        y--;
                    } else if (dir == 2) {
                        x--;
                    } else {
                        y++;
                    }
                    System.out.println("cleaner was turn back..!");
                    continue;
                } else {
                    System.out.println("exit Rocation= " + x + "," + y);
                    return;
                }
            }
            if (dir == 0) {
                ny--;
                dir = 3;
            } else if (dir == 1) {
                nx--;
                dir = 0;
            } else if (dir == 2) {
                ny++;
                dir = 1;
            } else if (dir == 3) {
                nx++;
                dir = 2;
            }
            System.out.println(nx + "," + ny +" /" +map[nx][ny]);
            if (map[nx][ny] == 0) {

                System.out.println(x+","+y +" clean!");
                for (int t[] : map) System.out.println(Arrays.toString(t));
                answer++;
                x = nx;
                y = ny;
                System.out.println("next location ="+x+","+y +" dir = " + dir);
            }
            cnt++;
        }

    }

    private static boolean canBack(int x, int y, int dir) {
        if (dir == 0) {
            if (x + 1 >= N || map[x + 1][y] == -1) return false;
        } else if (dir == 1) {
            if (y - 1 < 0 || map[x][y - 1] == -1) return false;
        } else if (dir == 2) {
            if (x - 1 < 0 || map[x - 1][y] == -1) return false;
        } else {
            if (y + 1 >= M || map[x][y + 1] == -1) return false;
        }

        return true;
    }

    public static boolean isIn(int x, int y) {
        if (x < 0 || y < 0 || x >= N || y >= M) return false;
        return true;
    }
}
