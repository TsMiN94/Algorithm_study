package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ1504 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    static int N, E;
    static int vertaxArr[];
    static int contains[] = new int[2];

    static int dist[];

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        vertaxArr = new int[N];

        dist = new int[N];
        List graph[] = new List[N];

        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());

            graph[a].add(new Vertax(b, c));
            graph[b].add(new Vertax(a, c));
        }

        st = new StringTokenizer(br.readLine());
        contains[0] = Integer.parseInt(st.nextToken()) - 1;
        contains[1] = Integer.parseInt(st.nextToken()) - 1;


        PriorityQueue<Vertax> pq = new PriorityQueue<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[0] = 0;

        pq.add(new Vertax(0, 0));
        while (!pq.isEmpty()) {
            //현재 정점에서 가장 가까운 거리의 정점

            Vertax curV = pq.poll();
            System.out.println("curV =" + curV.no);
            System.out.println(Arrays.toString(dist));
            if (curV.no == N - 1) {
                System.out.println(Arrays.toString(dist));
                System.out.println(Arrays.toString(vertaxArr));
                int cnt = 0;
                for (int i = 0; i < 2; i++) {
                    if (vertaxArr[contains[i]] > 0) cnt++;
                }
                if (cnt == 2)
                    answer = Math.min(answer, dist[N - 1]);
            }
            vertaxArr[curV.no]++;
            List<Vertax> child = graph[curV.no];
            for (int i = 0; i < child.size(); i++) {
                Vertax nextV = child.get(i);
                if (dist[nextV.no] > dist[curV.no] + nextV.cost) {
                    dist[nextV.no] = dist[curV.no] + nextV.cost;

                    pq.add(new Vertax(nextV.no, dist[nextV.no]));

                }
            }

        }

        if (answer == Integer.MAX_VALUE)
            answer = -1;
        System.out.println(answer);

    }

    static public class Vertax implements Comparable<Vertax> {
        int no, cost;

        public Vertax(int no, int cost) {
            this.no = no;
            this.cost = cost;
        }

        @Override
        public int compareTo(Vertax o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

}
