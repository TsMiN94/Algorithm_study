package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ2644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = -1;
    static int N, M;
    static int A, B;
    static List[] graph;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(br.readLine());
        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        Queue<Person> q = new LinkedList<>();
        q.add(new Person(A, 0));
        boolean[] visited = new boolean[N + 1];

        while (!q.isEmpty()) {
            Person cur = q.poll();
            visited[cur.no] = true;
            if (cur.no == B) {
                answer = cur.depth;
                break;
            }
            List<Integer> children = graph[cur.no];
            for (int i = 0; i < children.size(); i++) {
                int nextV = children.get(i);
                if (!visited[nextV]) {
                    q.add(new Person(nextV, cur.depth + 1));
                }
            }

        }

        System.out.println(answer);
    }

    static public class Person {
        int no, depth;

        public Person(int no, int depth) {
            this.no = no;
            this.depth = depth;
        }
    }
}
