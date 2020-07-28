package BackJun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No2178 {
    static int answer = 0;
    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static int N, M;
    static int[][] maze;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        sc.nextLine();

        maze = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            String str = sc.nextLine();
            for (int j = 0; j < M; j++) {
                maze[i][j] = str.charAt(j) - '0';
                visited[i][j] = false;
            }
        }
       // bfs(0, 0);
        System.out.println(maze[N - 1][M - 1]);
    }


    public static void bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(x, y));
        while (!q.isEmpty()) {

            Node node = q.poll();


            for (int i = 0; i < dx.length; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];

                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (visited[nx][ny] || maze[nx][ny] == 0) continue;

                q.add(new Node(nx, ny));
                maze[nx][ny] = maze[node.x][node.y] + 1;
                if (!visited[nx][ny])
                    visited[nx][ny] = true;

            }

        }
    }

    public static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;

        }
    }
}


