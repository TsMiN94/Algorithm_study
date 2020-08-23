package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1753 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int V, E;
    static List<Edge>[] graph;
    static int startV;
    static int[] weight;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new List[V + 1];

        weight = new int[V + 1];

        startV = Integer.parseInt(br.readLine());
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < weight.length; i++)
            weight[i] = Integer.MAX_VALUE;

        weight[startV] = 0;

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[from].add(new Edge(to, w));
        }
        BFS(startV);

        for (int i = 1; i < weight.length; i++) {
            if (weight[i] == Integer.MAX_VALUE)
                System.out.println("INF");
            else {
                System.out.println(weight[i]);
            }
        }

    }

    private static void BFS(int startV) {

        PriorityQueue<Edge> q = new PriorityQueue<>();

        q.add(new Edge(startV, 0));
        boolean[] check = new boolean[V + 1];

        while (!q.isEmpty()) {
            int s = q.poll().to;

            if (check[s]) continue;
            check[s] = true;

            List<Edge> childs = graph[s];
            for (int i = 0; i < childs.size(); i++) {
                Edge e = childs.get(i);
                if (weight[e.to] > e.cost + weight[s]) {
                    weight[e.to] = e.cost + weight[s];
                    q.add(new Edge(e.to, weight[e.to]));

                }
            }
        }
    }


    public static class Edge implements Comparable<Edge> {
        int to, cost;

        public Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }


        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }
}

