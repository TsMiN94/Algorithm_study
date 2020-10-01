package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ18352 {
    static int cities, edges, K, start;
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        cities = Integer.parseInt(st.nextToken());
        edges = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(st.nextToken()) - 1;
        List graph[] = new List[cities];
        List<Integer> answerList = new ArrayList<>();

        for (int i = 0; i < cities; i++) {
            graph[i] = new ArrayList<Integer>();
        }
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for (int i = 0; i < edges; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph[r - 1].add(c - 1);

        }
        dist = new int[cities];
        Arrays.fill(dist, Integer.MAX_VALUE);
        boolean visited[] = new boolean[cities];
        dist[start] = 0;

        pq.add(new Node(start, 0));
        while (!pq.isEmpty()) {
            Node curNode = pq.poll();
            if (curNode.dist == K) {
                answerList.add(curNode.no);
                continue;
            }
            int minIndex = curNode.no;
            List<Integer> list = graph[minIndex];
            for (int i = 0; i < list.size(); i++) {
                int to = list.get(i);
                if (!visited[to]) {
                    visited[to] = true;
                    pq.add(new Node(to, curNode.dist + 1));
                }
            }
        }

        Collections.sort(answerList);
        if (answerList.size() == 0) {
            System.out.println(-1);
        }else{
            for(int t: answerList)System.out.println(t+1);
        }

    }

    static public class Node implements Comparable<Node> {
        int no, dist;

        public Node(int no, int dist) {
            this.no = no;
            this.dist = dist;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.dist, o.dist);
        }
    }
}
