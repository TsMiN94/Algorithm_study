package VCNC;

import java.util.*;

public class No3 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int n = 5;
        int m = 4;
        int paths[][] = {
                {1, 2, 3, 2}, {1, 3, 2, 2}, {2, 4, 1, 1}, {2, 5, 4, 1}, {3, 5, 2, 2}, {4, 5, 2, 1}
        };
        System.out.println(s.solution(n, m, paths));
    }

    public static class Solution {
        List[] graph;
        int money;
        int N;
        int time[][];

        public int solution(int n, int m, int paths[][]) {
            int answer = 0;
            graph = new List[n + 1];
            time = new int[n + 1][2];
            money = m;
            N = n;
            for (int i = 0; i < n + 1; i++) {
                graph[i] = new ArrayList<Node>();
            }
            for (int i = 0; i < paths.length; i++) {
                int a = paths[i][0];
                int b = paths[i][1];
                int c = paths[i][2];
                int d = paths[i][3];
                graph[a].add(new Node(b, c, d));
            }
            for (int i = 0; i < n + 1; i++) Arrays.fill(time[i], Integer.MAX_VALUE);
            time[1][0] = 0;
            time[1][1] = 0;
            int curV = 1;
            boolean[] visited = new boolean[n + 1];
            Queue<Node> pq = new PriorityQueue<>();
            pq.add(new Node(1, 0, 0));
            while (!pq.isEmpty()) {
                Node curNode = pq.poll();
                int curNo = curNode.no;
                int minTime = curNode.time;
                visited[curNo] = true;
                List<Node> list = graph[curNo];
                for (int i = 0; i < list.size(); i++) {
                    Node next = list.get(i);
                    if (!visited[next.no]) {
                        if (time[next.no][0] > minTime + next.time && money >= curNode.cost + next.cost) {
                            time[next.no][0] = minTime + next.time;
                            time[next.no][1] = curNode.cost + next.cost;
                        } else if (time[next.no][0] == minTime + next.time && time[next.no][1] > next.cost + curNode.cost && money >= curNode.cost + next.cost) {
                            time[next.no][0] = minTime + next.time;
                            time[next.no][1] = curNode.cost + next.cost;
                        }
                        pq.add(new Node(next.no, time[next.no][0], time[next.no][1]));
                    }
                }
            }
            for (int t[] : time) System.out.println(Arrays.toString(t));
            answer = time[n][0];
            return answer;
        }
    }

    public static class Node implements Comparable<Node> {
        int no, time, cost;

        public Node(int no, int time, int cost) {
            this.no = no;
            this.time = time;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                return Integer.compare(this.cost, o.cost);
            } else {
                return Integer.compare(this.time, o.time);
            }
        }
    }
}
