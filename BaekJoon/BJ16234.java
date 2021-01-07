package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ16234 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int map[][];
    static int L, R;
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};

    static List<Integer> list;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean flag = true;
        while (flag) {
            flag = false;
            answer++;
            Queue<Integer> q = new LinkedList<>();
            boolean visited[] = new boolean[N * N];
            for (int i = 0; i < N * N; i++) {
                if (visited[i]) continue;
                list = new ArrayList<>();

                int r = i / N;
                int c = i % N;
                q.add(i);
                list.add(i);
                visited[i] = true;
                int sum = map[r][c];
                int n = 1;
                while (!q.isEmpty()) {
                    int cur = q.poll();
                    r = cur / N;
                    c = cur % N;
                    for (int j = 0; j < 4; j++) {
                        int nx = r + dx[j];
                        int ny = c + dy[j];
                        int next = nx * N + ny;
                        if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[next]) continue;
                        int cnt = map[nx][ny];
                        int pivot = map[r][c];
                        if (L <= Math.abs(pivot - cnt) && Math.abs(pivot - cnt) <= R) {
                            flag = true;
                            q.add(next);
                            list.add(next);
                            sum += cnt;
                            visited[next] = true;
                            n++;
                        }
                    }
                }
                int update = sum / n;
                if (list.size() > 1) {
                    for (int t : list) {
                        r = t / N;
                        c = t % N;
                        map[r][c] = update;
                    }
                }
            }

        }

        System.out.println(answer-1);
    }


}
