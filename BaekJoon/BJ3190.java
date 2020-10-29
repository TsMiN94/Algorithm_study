package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ3190 {
    static int N;
    static char map[][];
    static int dx[] = {0, 1, 0, -1};
    static int dy[] = {1, 0, -1, 0};
    static char order[] = new char[10001];
    static Deque<Point> snake;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new char[N][N];
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) Arrays.fill(map[i], 'N');
        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x-1][y-1] = 'A';
        }

        int L = Integer.parseInt(br.readLine());
        Arrays.fill(order, 'N');
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            char o = st.nextToken().charAt(0);
            order[index] = o;
        }

        snake = new LinkedList<>();
        snake.add(new Point(0, 0));


        go(0, 0, 0);


    }

    private static void go(int x, int y, int dir) {
        int time = 0;
        map[0][0] = 'S';
        while (true) {
            time++;
            int nx = snake.getFirst().x + dx[dir];
            int ny = snake.getFirst().y + dy[dir];
            if (!check(nx, ny) || map[nx][ny] == 'S') break;
            // 사과를 먹으면
            if (map[nx][ny] == 'A') {
                map[nx][ny] = 'S';
                snake.addFirst(new Point(nx, ny));
            } else if(map[nx][ny]=='N'){
                map[nx][ny] = 'S';
                snake.addFirst(new Point(nx, ny));
                Point tail = snake.removeLast();
                map[tail.x][tail.y]= 'N';
            }

            char curDir = order[time];
            if (curDir == 'D') {
                dir++;
                dir %= 4;
            } else if (curDir == 'L') {
                dir--;
                if (dir < 0) {
                    dir = 3;
                }
            }

        }
        System.out.println(time);

    }

    public static boolean check(int nx, int ny) {

        if (nx < 0 || ny < 0 || nx >= N || ny >= N) {
            return false;
        }

        return true;
    }

    public static class Point {
        int x, y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}
