package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class Solution_모의SW역량_최장경로 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static List[] graph;
    static boolean visited[];

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            answer = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            graph = new List[N];
            visited = new boolean[N];

            for (int i = 0; i < N; i++)
                graph[i] = new ArrayList<Integer>();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 0; i < N; i++) {
                visited[i] = true;
                DFS(i, 1);
                visited[i] = false;

//                System.out.println();
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    private static void DFS(int no, int cnt) {
//        System.out.print(no + " -> ");
        List<Integer> edges = graph[no];
        for (int i = 0; i < edges.size(); i++) {
            int nextVertax = edges.get(i);
            if (!visited[nextVertax]) {
                visited[nextVertax] = true;
                DFS(nextVertax, cnt + 1);
                visited[nextVertax] = false;
            }
        }

        answer = Math.max(answer, cnt);

    }
}
