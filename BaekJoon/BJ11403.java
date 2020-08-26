package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ11403 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int arr[][];
    static List<Integer> graph[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        arr = new int[N][N];
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            graph[i] = new ArrayList<>();
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[j][i] = arr[i][j];
                if (arr[i][j] == 1) {
                    graph[i].add(j);
                }
            }
        }


        BFS(0);

    }

    private static void BFS(int v) {
        Queue<Integer> q = new LinkedList<>();
        q.add(v);
        while (!q.isEmpty()) {
            int curV = q.poll();
            List<Integer> others = graph[curV];
            for (int i = 0; i < others.size(); i++) {

            }
        }
    }


}
