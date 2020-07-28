package Kakao2020Blind;

public class Fomula {
    public static void main(String[] args) {
        int[][] arr = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}};
        int[][] arr2 = {
                {0, 0, 0, 0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1},
                {0, 0, 1, 0, 0, 0, 1, 0},
                {0, 1, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0}};

        int arr3[][] = {
                {0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 1, 0},
                {0, 0, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 1},
                {0, 1, 0, 0, 0, 1},
                {0, 0, 0, 0, 0, 0}
        };


        Solution s = new Solution();
        System.out.println(s.solution(arr3));
    }

    static class Solution {
        static int min = Integer.MAX_VALUE;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        public int solution(int[][] board) {

            int len = board.length;
            boolean visited[][] = new boolean[len][len];
            dfs(board, visited, 0, 0, 0, 0);
            return min;

        }

        private void dfs(int[][] board, boolean[][] visited, int currentX, int currentY, int preDirection, int cost) {
            if (currentX == (board.length - 1) && (currentY == board.length - 1)) {
                min = Math.min(min, cost);
                return;

            } else {
                for (int i = 0; i < 4; i++) {
                    int nx = dx[i] + currentX;
                    int ny = dy[i] + currentY;

                    if (nx < 0 || ny < 0 || nx >= board.length || ny >= board.length) {
                        continue;
                    }
                    if (visited[nx][ny] || board[nx][ny] == 1)
                        continue;

                    visited[nx][ny] = true;

                    int nextDir = 0;
                    // 수직
                    if (i % 2 == 0)
                        nextDir = 1;
                    else //수평
                        nextDir = -1;

                    if (preDirection != 0) {
                        if (preDirection != nextDir)
                            dfs(board, visited, nx, ny, nextDir, cost + 600);
                        else
                            dfs(board, visited, nx, ny, nextDir, cost + 100);
                    }
                    //맨처음 0,0 좌표 예외 처리
                    else {
                        dfs(board, visited, nx, ny, nextDir, cost + 100);
                    }

                    visited[nx][ny] = false;
                }

            }

        }

    }
}