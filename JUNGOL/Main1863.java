package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main1863 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int student[], rank[];
    static int n, m;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        makeSet();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            union(f, t);

        }

        int cnt = 0;
        for(int i = 1; i<=n; i++) {
            if(i == student[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);

    }

    private static void union(int f, int t) {
        int a = findSet(f);
        int b = findSet(t);
        if (a != b) {
            if (rank[a] == rank[b]) {
                rank[a]++;
                student[b] = a;
            }
            else if (rank[a] < rank[b])
                student[a] = b;
            else
                student[b] = a;
        }
    }

    private static int findSet(int x) {
        if (student[x] == x) {
            return x;
        } else {
            return student[x] = findSet(student[x]);
        }
    }

    private static void makeSet() {
        student = new int[n + 1];
        rank = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            student[i] = i;
            rank[i] = 1;
        }
    }


}
