package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BJ12581 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N, K;
    static int answer = 0;
    static StringTokenizer st;
    static int visited[];

    public static void main(String[] args) {

    }

    private static void BFS(int n) {
        Queue<Integer> q = new LinkedList<Integer>();
        q.add(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int curN = q.poll();
            if (curN == K) {
                break;
            }
            if (curN + 1 <= 100000 && visited[curN + 1] == 0) {
                q.add(curN + 1);
                visited[curN + 1] = visited[curN] + 1;
            }
            if (curN - 1 >= 0 && visited[curN - 1] == 0) {
                q.add(curN - 1);
                visited[curN - 1] = visited[curN] + 1;
            }
            if (curN * 2 <= 100000 && visited[curN * 2] == 0) {
                q.add(curN * 2);
                visited[curN * 2] = visited[curN] + 1;
            }


        }
        System.out.println(visited[K] - 1);
    }
}
