package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ11779 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static long answer = Long.MAX_VALUE;
    static int N, M;
    static int s, e;
    static List[] graph;
    static String path;

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        long dist[] = new long[N + 1];
        int route[] = new int[N + 1];
        Arrays.fill(dist, Long.MAX_VALUE);

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            graph[a].add(new Node(b, cost));
        }

        s = sc.nextInt();
        e = sc.nextInt();

        dist[s] = 0;
        Queue<Node> q = new PriorityQueue<>();
        q.add(new Node(s, 0));
        boolean visited[] = new boolean[N + 1];

        while (!q.isEmpty()) {
            Node cur = q.poll();
            visited[cur.no] = true;
            if (cur.no == e) {
                if (answer > cur.cost) {
                    answer = cur.cost;
                }
            }
            // System.out.println(cur.path+"/"+cur.cost);
            List<Node> nextVertaxList = graph[cur.no];
            for (int i = 0; i < nextVertaxList.size(); i++) {
                Node nextV = nextVertaxList.get(i);
                if (!visited[nextV.no] && dist[nextV.no] > dist[cur.no] + nextV.cost) {
                    dist[nextV.no] = dist[cur.no] + nextV.cost;
                    route[nextV.no] = cur.no;
                    q.add(new Node(nextV.no, dist[nextV.no]));
                }
            }
        }
        System.out.println(answer);
        Stack<Integer> stack = new Stack<>();
        while (true) {
            stack.push(e);
            e = route[e];
            if (e == s) {
                stack.push(e);
                break;
            }
        }
        System.out.println(stack.size());
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static class Node implements Comparable<Node> {
        int no;
        long cost;


        public Node(int no, long cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.cost, o.cost);
        }
    }


}
