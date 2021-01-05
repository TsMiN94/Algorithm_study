package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static List[] graph;
    static int vertax[];

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        vertax = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        BFS(1);
        for(int i =2 ; i < N+1; i++)
            System.out.println(vertax[i]);
    }

    private static void BFS(int root) {
        Queue<Integer> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> children = graph[cur];
            for (int i = 0; i < children.size(); i++) {
                int nextV = children.get(i);
                if (vertax[nextV] == 0) {
                    vertax[nextV] = cur;
                    q.add(nextV);
                }
            }
        }
    }
}
