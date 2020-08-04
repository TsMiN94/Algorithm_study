package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class D41238 {
    static int N;
    static boolean adjArr[][];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int t = 1;
        while ((line = br.readLine()) != null) {

            StringTokenizer st = new StringTokenizer(line);
            N = Integer.parseInt(st.nextToken());
            int startV = Integer.parseInt(st.nextToken());


            adjArr = new boolean[N + 1][N + 1];
            st = new StringTokenizer(br.readLine());
            int len = st.countTokens();
            for (int i = 0; i < len / 2; i++) {
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                adjArr[from][to] = true;
            }
            BFS(startV);
            System.out.println("#" + t + " " + answer);
            t++;
            answer= 0;
        }

    }

    private static void BFS(int startV) {
        Queue<Node> q = new LinkedList<>();
        ArrayList<Node> nodeList = new ArrayList<>();

        boolean[] visited = new boolean[N + 1];
        visited[startV] = true;
        q.add(new Node(1, startV));
        nodeList.add(new Node(1, startV));

        int depth = 0;
        int max = 1;

        while (!q.isEmpty()) {
            Node node = q.poll();
            depth = node.depth;

            for (int i = 1; i <= N; i++) {
                if (adjArr[node.v][i] && !visited[i]) {
                    visited[i] = true;
                    q.add(new Node(depth + 1, i));
                    nodeList.add(new Node(depth + 1, i));
                }
            }
            max = Math.max(max, depth);
        }

        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).depth == max) {
                answer = Math.max(answer,nodeList.get(i).v);
            }
        }
    }

    static class Node {
        int depth, v;

        public Node(int depth, int v) {
            this.depth = depth;
            this.v = v;
        }
    }


}
