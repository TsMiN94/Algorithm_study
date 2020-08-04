package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.*;

/*

4 5 1
1 2
1 3
1 4
2 4
3 4

 */
public class BJ1260 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static String src =
            "5 5 3\n" +
                    "5 4\n" +
                    "5 2\n" +
                    "1 2\n" +
                    "3 4\n" +
                    "3 1";
    static int N, M, V;
    static List<Integer>[] graph;
    //static boolean[] visited;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new StringReader(src));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];

        for (int i = 1; i <= N; i++)
            graph[i] = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            graph[from].add(to);
            graph[to].add(from);
        }

        for (int i = 1; i < graph.length; i++) {
            Collections.sort(graph[i]);
        }

        DFS(V, new boolean[N + 1]);
        System.out.println(sb.toString());
        BFS(V, new boolean[N + 1]);
        System.out.println(sb.toString());
    }

    private static void BFS(int v, boolean[] visited) {
        Queue<Integer> q = new LinkedList<>();
        sb = new StringBuilder();
        visited[v] = true;
        q.add(v);
        while (!q.isEmpty()) {

            int front = q.poll();
            List<Integer> childs = graph[front];
            sb.append(front).append(" ");
            for (int i = 0; i < childs.size(); i++) {
                int nextV = childs.get(i);
                if (!visited[nextV]) {
                    visited[nextV] = true;
                    q.add(nextV);

                }
            }
        }
    }

    private static void DFS(int v, boolean[] visited) {
        visited[v] = true;

        sb.append(v).append(" ");
        List<Integer> child = graph[v];
        for (int i = 0; i < child.size(); i++) {
            int nextV = child.get(i);
            if (!visited[nextV])
                DFS(nextV, visited);
        }

    }
}
