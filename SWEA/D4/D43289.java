package SWEA_D4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class D43289 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    static int pArr[], N;
    static int rank[];

    public static void main(String[] args) throws IOException {

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ");
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            pArr = new int[N + 1];

            makeSet();

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int op = Integer.parseInt(st.nextToken());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                if (op == 0) {
                    union(a, b);
                } else if (op == 1) {
                    int repA = findSet(a);
                    int repB = findSet(b);
                    sb.append(repA == repB ? "1" : "0");
                }

            }
            System.out.println(sb.toString());
            sb.append("\n");
        }
    }

    private static int findSet(int x) {
        if (pArr[x] == x) {
            return x;
        } else {
            return pArr[x] = findSet(pArr[x]);
        }
    }

    private static void makeSet() {
        rank = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            pArr[i] = i;
            rank[i] = 1;
        }
    }

    private static void union(int a, int b) {
        int x = findSet(a);
        int y = findSet(b);

        if (x != y) {
            if (rank[x] == rank[y]) {
                rank[x]++;
            } else if (rank[x] < rank[y]) {
                pArr[x] = y;
            } else
                pArr[y] = x;
        }
    }
}
