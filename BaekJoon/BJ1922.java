package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1922 {
    static int arr[][];
    static int N, M;
    static List[] graph;
    static int dist[];
    static boolean visited[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N][N];

        visited = new boolean[N + 1];
        graph = new List[N + 1];
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i <= N; i++) graph[i] = new ArrayList<Node>();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, cost));
            graph[b].add(new Node(a, cost));

        }
        int answer = 0;
        dist[1] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(1, 0));
        while (!pq.isEmpty()) {
            Node minverTax = pq.poll();

            if (visited[minverTax.no]) continue;

            answer += minverTax.cost;
            visited[minverTax.no] = true;
            List<Node> child = graph[minverTax.no];
            for (int i = 0; i < child.size(); i++) {
                Node temp = child.get(i);
                if (!visited[temp.no] && dist[temp.no] > temp.cost) {
                    dist[temp.no] = temp.cost;
                    pq.add(new Node(temp.no, temp.cost));
                }
            }

        }
        System.out.println(answer);
    }


    public static class Node implements Comparable<Node> {
        int no, cost;

        public Node(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
}
