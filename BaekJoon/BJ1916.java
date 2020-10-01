package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ1916 {
    static List graph[];
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Node>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            graph[f].add(new Node(t, value));


        }

        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        dist[start] = 0;
        boolean visited[] = new boolean[N + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            int minIdx = curNode.x;
            int minDist = curNode.dist;
            visited[minIdx] = true;
            List<Node> list = graph[minIdx];
            for (int i = 0; i < list.size(); i++) {
                Node nextNode = list.get(i);
                if (!visited[nextNode.x] && dist[nextNode.x] > minDist + nextNode.dist) {
                    dist[nextNode.x] = minDist + nextNode.dist;
                    pq.add(new Node(nextNode.x, dist[nextNode.x]));
                }

            }

        }
        System.out.println(dist[target]);

    }

    public static class Node implements Comparable<Node> {
        int x, dist;

        public Node(int x, int dist) {
            this.x = x;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
