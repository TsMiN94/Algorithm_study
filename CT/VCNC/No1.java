package VCNC;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No1 {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] cars = {22, 9, 1, 15, 8, 6, 20, 7, 11, 5, 10, 4, 1};
        int[][] links = {
                {4, 7}, {13, 10}, {6, 3}, {7, 1}, {6, 12}, {5, 11}, {5, 6}, {5, 10},
                {9, 8}, {8, 11}, {8, 2}, {7, 8}
        };
        System.out.println(s.solution(13, cars, links));
    }

    static class Solution {
        static List[] graph;
        static int N;
        static int[] arr;

        public int solution(int n, int[] cars, int[][] links) {
            int answer = Integer.MAX_VALUE;
            int size = links.length;
            N = n;
            arr = cars;
            graph = new List[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new LinkedList<Integer>();
            }
            for (int i = 0; i < size; i++) {
                int a = links[i][0] - 1;
                int b = links[i][1] - 1;
                graph[a].add(b);
                graph[b].add(a);
            }

            for (int i = 0; i < size; i++) {
                int a = links[i][0] - 1;
                int b = links[i][1] - 1;
                graph[a].remove((Object) b);
                graph[b].remove((Object) a);

                int aSum = BFS(a);
                int bSum = BFS(b);
                System.out.println(a + "정점에서 " + b + " 로가는 간선 제거");
                System.out.println(aSum + "/" + bSum);
                answer = Math.min(answer, Math.abs(aSum - bSum));

                graph[a].add(b);
                graph[b].add(a);
            }
            return answer;
        }

        private int BFS(int v) {

            int sum = 0;
            Queue<Integer> q = new LinkedList<>();
            q.add(v);
            boolean[] visited = new boolean[N];
            while (!q.isEmpty()) {
                int curV = q.poll();
                sum += arr[curV];
                visited[curV] = true;
                List<Integer> children = graph[curV];
                for (int i = 0; i < children.size(); i++) {
                    int nextV = children.get(i);
                    if (!visited[nextV]) {
                        q.add(nextV);
                    }
                }
            }

            return sum;
        }
    }

    static class Edge {
        int n1, n2;

        public Edge(int n1, int n2) {
            this.n1 = n1;
            this.n2 = n2;
        }
    }

}
