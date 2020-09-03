package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class D41251 {
    static long answer = 0;

    static double E;
    static long min = Long.MAX_VALUE;
    static long graph[][];
    static long minDist[];
    static boolean visited[];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());

            StringTokenizer stX = new StringTokenizer(br.readLine());
            StringTokenizer stY = new StringTokenizer(br.readLine());
            int arrx[] = new int[n];
            int arry[] = new int[n];
            minDist = new long[n];
            visited = new boolean[n];
            graph = new long[n][n];
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(stX.nextToken());
                int y = Integer.parseInt(stY.nextToken());
                arrx[i] = x;
                arry[i] = y;

                minDist[i] = (long) Double.MAX_VALUE;
            }
            E = Double.parseDouble(br.readLine());
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    double dist = Math.pow(arrx[i] - arrx[j], 2) + Math.pow(arry[i] - arry[j], 2);
                    graph[i][j] = graph[j][i] = (long) dist;
                }
            }



                build(0);
            System.out.println("#" + t + " " + Math.round(answer * E));
            answer = 0;

        }
    }

    private static void build(int startV) {
        PriorityQueue<Island> pq = new PriorityQueue<>();
        int cnt = 0;
        pq.offer(new Island(startV, 0));
        minDist[0] = 0;
        while (!pq.isEmpty()) {
            Island cur = pq.poll();

            if (visited[cur.from]) continue;

            answer += cur.cost;
            visited[cur.from] = true;
            if (++cnt == n) return;
            for (int i = 0; i < n; i++) {
                if (!visited[i] && graph[cur.from][i] != 0 && graph[cur.from][i] < minDist[i]) {
                    minDist[i] = graph[cur.from][i];
                    pq.add(new Island(i, graph[cur.from][i]));
                }
            }

        }

    }

    static class Island implements Comparable<Island> {
        int from;
        double cost;

        public Island(int from, double cost) {
            this.from = from;
            this.cost = cost;
        }

        @Override
        public int compareTo(Island o) {
            return Double.compare(this.cost, o.cost);
        }
    }

}
