package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ17141 {
    static int map[][], dist[][];
    static int N, V;
    static int answer = Integer.MAX_VALUE;
    static List<Point> virus = new LinkedList<>();
    static Point[] selectedVirus;
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};
    static boolean flag = false;
    static List<Integer> cases = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        dist = new int[N][N];

        for (int i = 0; i < N; i++) Arrays.fill(dist[i], Integer.MAX_VALUE);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new Point(i, j, 0));
                }
                if (map[i][j] == 1) {
                    dist[i][j] = -1;
                    cnt++;
                }
            }
        }

        selectedVirus = new Point[V];
        Arrays.fill(selectedVirus, null);
        //49 -14 -2

        comb(0, 0);

        Collections.sort(cases);
        if (cases.size() > 0) {
            System.out.println(cases.get(0));
        } else
            System.out.println(-1);

    }

    private static void comb(int cnt, int start) {
        if (cnt == V) {
            Queue<Point> q = new LinkedList<>();

            BFS(selectedVirus);


            return;
        }

        for (int i = start; i < virus.size(); i++) {
            selectedVirus[cnt] = virus.get(i);
            comb(cnt + 1, i + 1);
        }
    }

    private static void BFS(Point[] selectedVirus) {
        Queue<Point> q = new LinkedList<>();
        int max = 0;
        int cnt = 0;
        int cloneDist[][] = new int[N][N];
        for (int i = 0; i < N; i++)
            cloneDist[i] = dist[i].clone();

        for (int i = 0; i < V; i++) {
            if (selectedVirus[i] != null) {
                Point temp = selectedVirus[i];
                q.add(new Point(temp.x, temp.y, temp.cnt));
                cloneDist[temp.x][temp.y] = 0;
            }
        }


        while (!q.isEmpty()) {
            Point curVirus = q.poll();
            cnt++;

            max = Math.max(curVirus.cnt, max);
            for (int i = 0; i < 4; i++) {
                int nx = dx[i] + curVirus.x;
                int ny = dy[i] + curVirus.y;
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || cloneDist[nx][ny] == -1)
                    continue;
                if (cloneDist[nx][ny] > curVirus.cnt + 1) {
                    cloneDist[nx][ny] = curVirus.cnt + 1;
                    q.add(new Point(nx, ny, curVirus.cnt + 1));
                }
            }


        }

        for (int i = 0; i < cloneDist.length; i++) {
            Arrays.sort(cloneDist[i]);
            if (cloneDist[i][N-1] == Integer.MAX_VALUE)
                return;
        }

        cases.add(max);

    }

    public static class Point {
        int x, y, cnt;


        public Point(int x, int y, int cnt) {
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
}
