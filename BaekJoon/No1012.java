package BackJun;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class No1012 {
    static int row, col;
    static int size;
    static int[][] m;
    static int warm = 0;

    static int dx[] = {0, -1, 0, 1};
    static int dy[] = {1, 0, -1, 0};
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int k = 0; k < n; k++) {
            row = sc.nextInt();
            col = sc.nextInt();
            size = sc.nextInt();
            m = new int[row][col];
            visited = new boolean[row][col];
            for (int i = 0; i < row; i++)
                for (int j = 0; j < col; j++)
                    m[i][j] = 0;

            for (int i = 0; i < size; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                m[x][y] = 1;
            }

            bfs(0, 0);
            System.out.println(warm);
            warm =0;
        }
    }

    private static void bfs(int x, int y) {
        for (int j = x; j < row; j++) {
            for (int k = y; k < col; k++) {
                if (!visited[j][k] && m[j][k] == 1) {
                    Queue<Node> q = new LinkedList<>();
                    q.add(new Node(j, k));

                    while (!q.isEmpty()) {
                        Node node = q.poll();

                        if (!visited[node.x][node.y])
                            visited[node.x][node.y] = true;

                        for (int i = 0; i < dx.length; i++) {

                            int nx = node.x + dx[i];
                            int ny = node.y + dy[i];
                            if (nx < 0 || ny < 0 || nx >= row || ny >= col) continue;
                            if (visited[nx][ny] || m[nx][ny] == 0) continue;

                            q.add(new Node(nx, ny));
                        }

                    }
                    warm++;

                }
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
