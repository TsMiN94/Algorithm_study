package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ1238 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M, X;
    static List[] graph;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1;
        graph = new List[N];


        int targetDist[] = new int[N];

        int homeDist[] = new int[N];
        Arrays.fill(targetDist, Integer.MAX_VALUE);
        Arrays.fill(homeDist, Integer.MAX_VALUE);

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int time = Integer.parseInt(st.nextToken());
            graph[a].add(new Node(b, time));
        }


        for (int i = 0; i < N; i++) {
            int dist[] = new int[N];
            Arrays.fill(dist,Integer.MAX_VALUE);
            dist[i] = 0;
            Queue<Node> q = new PriorityQueue<>();
            q.add(new Node(i, 0));
            boolean visited[] = new boolean[N];
            while (!q.isEmpty()) {
                Node cur = q.poll();
                visited[cur.no] = true;
                List<Node> nextVertaxList = graph[cur.no];
                for (int j = 0; j < nextVertaxList.size(); j++) {
                    Node nextNode = nextVertaxList.get(j);
                    int nextV = nextNode.no;
                    int cost = nextNode.time;
                    if (!visited[nextV] && dist[nextV] > dist[cur.no] + cost) {
                        dist[nextV] = dist[cur.no] + cost;
                        q.add(new Node(nextV, dist[nextV]));
                    }
                }
            }
            targetDist[i] = dist[X];
        }
        //.out.println(Arrays.toString(targetDist));

        Queue<Node> q = new PriorityQueue<>();
        homeDist[X] = 0;
        q.add(new Node(X, 0));
        boolean visited[] = new boolean[N];
        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.no] = true;
            List<Node> nextVertaxList = graph[cur.no];
            for (int j = 0; j < nextVertaxList.size(); j++) {
                Node nextNode = nextVertaxList.get(j);
                int nextV = nextNode.no;
                int cost = nextNode.time;
                if (!visited[nextV] && homeDist[nextV] > homeDist[cur.no] +cost) {
                    homeDist[nextV] = homeDist[cur.no] + cost;
                    q.add(new Node(nextV, homeDist[nextV]));
                }
            }
        }
        answer = Integer.MIN_VALUE;

        //System.out.println(Arrays.toString(homeDist));

        for (int i = 0; i < N; i++) {
            answer = Math.max(answer, homeDist[i] + targetDist[i]);
        }
        System.out.println(answer);
    }

    public static class Node implements Comparable<Node> {
        int no, time;

        public Node(int no, int time) {
            this.no = no;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

}
