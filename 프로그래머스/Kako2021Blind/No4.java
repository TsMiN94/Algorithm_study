package Kakao2021Blind;

import java.util.*;

public class No4 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 7;
        int s = 3;
        int a = 4;
        int b = 1;
        int[][] f2 = {
                {5, 7, 9}, {4, 6, 4}, {3, 6, 1}, {3, 2, 3}, {2, 1, 6}};


        int[][] fares =
                {
                        {4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                        {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                        {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                };
        int res = solution.solution(n, s, a, b, f2);
        System.out.println(res);
    }

    static class Solution {
        static int p[];
        static boolean visited[];
        static Queue[] graph;
        static int answer = 0;
        static int A = 0, B = 0;

        public int solution(int n, int s, int a, int b, int[][] fares) {
            int answer = 0;

            graph = new Queue[n + 1];
            visited = new boolean[n + 1];

            for (int i = 0; i <= n; i++) {
                graph[i] = new PriorityQueue<>();
            }
            for (int i = 0; i < fares.length; i++) {
                int no = fares[i][0];
                int to = fares[i][1];
                int cost = fares[i][2];
                graph[no].add(new Node(to, cost));
                graph[to].add(new Node(no, cost));
            }

            outer:
            while (true) {
                int curV = s;
                visited[curV] = true;
                if (visited[a] && visited[b]) break;
                Queue<Node> child = graph[curV];

                while (!child.isEmpty()) {
                    Node minDist = child.poll();
                    //System.out.println(minDist);
                    if (visited[minDist.to]) continue;
                    answer += minDist.cost;
                    visited[minDist.to] = true;

                    if (minDist.to == a || minDist.to == b) {
                        continue;
                    } else {
                        break;
                    }
                }

            }

            return answer;
        }

        private void makeSet(int n) {
            p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                p[i] = i;
            }
        }

        private int findSet(int x) {
            if (p[x] == x) return x;
            else
                return p[x] = findSet(p[x]);
        }

        private boolean union(int a, int b) {
            a = findSet(a);
            b = findSet(b);
            if (a != b) {
                p[b] = a;
                return true;
            } else
                return false;
        }
    }

    public static class Node implements Comparable<Node> {
        int to, cost;

        public Node(int no, int cost) {
            this.to = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }

    }

}
