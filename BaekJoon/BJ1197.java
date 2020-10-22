package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BJ1197 {
    static int V, E;
    static int parent[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) parent[i] = i;

        PriorityQueue<Edge> edges = new PriorityQueue<>();
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            edges.add(new Edge(a, b, cost));
        }
        int answer = 0;
        int size= edges.size();
        for (int i=0 ; i < size;i++) {
            Edge e = edges.poll();
            if (union(e.aVertax, e.bVertax)) {
                answer += e.cost;
            }
        }

        System.out.println(answer);
    }

    public static int findSet(int x) {
        if (parent[x] == x) return x;
        return parent[x] = findSet(parent[x]);
    }

    public static boolean union(int a, int b) {
        a = findSet(a);
        b = findSet(b);
        if (a != b) {
            parent[b] = a;
            return true;
        }
        return false;

    }


    public static class Edge implements Comparable<Edge> {
        int aVertax, bVertax, cost;

        public Edge(int aVertax, int bVertax, int cost) {
            this.aVertax = aVertax;
            this.bVertax = bVertax;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
