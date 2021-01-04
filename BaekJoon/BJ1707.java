package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ1707 {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static int V, E;
    static List[] graph;
    static boolean answer = true;
    static int vertax[];
    static boolean[] visited;
    static int value = 1;

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            answer = true;
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            graph = new ArrayList[V + 1];
            vertax = new int[V + 1];
            visited = new boolean[V + 1];

            for (int i = 0; i < V + 1; i++)
                graph[i] = new ArrayList<Integer>();

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }


            for (int i = 1; i < V + 1; i++) {
                if (!visited[i]) {
                    BFS(i);
                }
            }
            for (int i = 1; i < V + 1; i++) {
                List<Integer> children = graph[i];
                for (int j = 0; j < children.size(); j++) {
                    if (vertax[children.get(j)] == vertax[i]) {
                        answer = false;
                        break;
                    }
                }
            }

            if (answer) System.out.println("YES");
            else System.out.println("NO");
        }
    }

    private static void BFS(int curV) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(curV, value));
        visited[curV] = true;
        vertax[curV] = value;

        while (!q.isEmpty()) {
            Node node = q.poll();
            visited[node.no] = true;

            List<Integer> child = graph[node.no];
            for (int i = 0; i < child.size(); i++) {
                int nextV = child.get(i);
                if (!visited[nextV]) {
                    vertax[nextV] = node.val * -1;
                    q.add(new Node(nextV, node.val * -1));
                }
            }

        }

    }

    public static class Node {
        int no, val;

        public Node(int no, int val) {
            this.no = no;
            this.val = val;
        }
    }


}
