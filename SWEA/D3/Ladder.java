package SWEA._D3;

import java.io.*;
import java.util.StringTokenizer;

/**
 * @Author mts
 * @date 2020 07 28
 * @link https://swexpertacademy.com/main/solvingProblem/solvingProblem.do
 * @time 167
 * @mem 37000
 * @catuion [고려사항] 마지막 종착지 인덱스가 2임
 * [출력사항]
 */
public class Ladder {
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int ladder[][] = new int[100][100];
            String T;
            T = br.readLine();
            for (int i = 0; i < 100; i++) {
                String str = br.readLine();
                StringTokenizer st = new StringTokenizer(str, " ");
                int j = 0;
                while (st.hasMoreTokens()) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                    j++;
                }
            }


            for (int i = 0; i < 100; i++) {
                boolean visited[][] = new boolean[100][100];
                find(ladder, visited, 0, 0, i);
                if(answer != -1) {
                    System.out.println("#" + test_case + " " + answer);
                    break;
                }
            }

        }
    }

    private static void find(int[][] ladder, boolean[][] visited, int row, int col, int startIdx) {
        int dy[] = {1, -1};
        if (row == 100) {
            if (ladder[row-1][col] ==2)
                answer = startIdx;
            else
                answer = -1;
            return;
        }

        if (ladder[0][startIdx] == 1) {
            if (row == 0) {
                visited[row + 1][startIdx] = true;
                find(ladder, visited, row + 1, startIdx, startIdx);
            } else {
                boolean flag = false;
                //양쪽을 검사
                for (int i = 0; i < 2; i++) {
                    int ny = col + dy[i];
                    if (ny < 0 || ny >= 100) continue;
                    if (visited[row][ny]) continue;
                    if (ladder[row][ny] == 1) {
                        visited[row][ny] = true;
                        find(ladder, visited, row, ny, startIdx);
                        flag = true;
                        break;
                    }
                }
                //양쪽이 갈 사다리가 없을경우 아래로
                if (!flag) {
                    if (row != 99)
                        visited[row + 1][col] = true;
                    find(ladder, visited, row + 1, col, startIdx);
                }
            }
        }

    }

}
