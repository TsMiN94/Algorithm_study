package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14496 {
    static int parent[];
    static List[] graph;
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int target = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        graph = new List[N + 1];
        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<Integer>();
        }

        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            graph[f].add(t);
            graph[t].add(f);
        }

        dist[start] = 0;
        boolean visited[] = new boolean[N + 1];
        for (int i = 1; i < N + 1; i++) {
            int minIdx = 1;
            int minDist = Integer.MAX_VALUE;
            for (int j = 1; j < N + 1; j++) {
                if (!visited[j] && dist[j] < minDist) {
                    minDist = dist[j];
                    minIdx = j;
                }
            }
            visited[minIdx] = true;
            List<Integer> list = graph[minIdx];
            for (int j = 0; j < list.size(); j++) {
                int to = list.get(j);
                if (!visited[to] && dist[to] > dist[minIdx] + 1) {
                    dist[to] = dist[minIdx] + 1;
                }
            }

        }

        if (dist[target] != Integer.MAX_VALUE) {
            System.out.println(dist[target]);
        } else
            System.out.println(-1);

    }


}
