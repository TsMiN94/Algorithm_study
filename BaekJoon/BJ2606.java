package BackJun;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.List;

public class BJ2606 {
    static List<Integer> list[];
    static int N, size;
    static int answer = 0;
    static int arr[];

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        size = Integer.parseInt(br.readLine());
        list = new List[N + 1];
        arr = new int[N + 1];
        makeSet();
        for (int i = 0; i <= N; i++)
            list[i] = new ArrayList<>();

        for (int i = 0; i < size; i++) {

            StringTokenizer st = new StringTokenizer(br.readLine());
            int f = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[f].add(t);
            list[t].add(f);
            union(f, t);
        }
        for (int i : arr) System.out.print(i + " ");

        BFS(1);
        System.out.println(answer);
    }

    private static void BFS(int s) {
        boolean visited[] = new boolean[N + 1];
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        visited[s] = true;
        while (!q.isEmpty()) {

            int v = q.poll();
            System.out.println(v);
            List<Integer> edge = list[v];
            for (int i = 0; i < edge.size(); i++) {
                int to = edge.get(i);
                System.out.println(to);
                if (!visited[to]) {
                    if (findSet(v) == 1 && findSet(to) == 1) {
                        q.add(to);
                        answer++;
                        visited[to] = true;
                    }
                }
            }


        }

    }

    public static void makeSet() {
        for (int i = 1; i <= N; i++)
            arr[i] = i;
    }

    public static int findSet(int x) {
        if (arr[x] == x) return x;
        else {
            return arr[x] = findSet(arr[x]);
        }
    }

    public static boolean union(int x, int y) {
        x = findSet(x);
        y = findSet(y);

        if (x != y) {
            if (x == 1) {
                arr[y] = 1;
            } else if (y == 1) {
                arr[x] = 1;
            } else {
                arr[y] = x;
            }
            return true;
        } else return false;
    }


}
