package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BJ14501 {
    static int N = 0;
    static boolean visited[];
    static List<Meet> list;
    static int answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        list = new ArrayList<>();
        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            list.add(new Meet(end, cost));
        }

        subSet(0);

        System.out.println(answer);

    }

    private static void subSet(int cnt) {
        if (cnt == N) {
            int sum = 0, day = 0;
            for (int i = 0; i < N; ) {

                if (visited[i]) {
                    Meet meet = list.get(i);

                    if (i + meet.end <= N) {
                        sum += meet.cost;
                        i += meet.end;

                        continue;
                    }

                    i++;
                    continue;
                }
                i++;
            }
            answer = Math.max(sum, answer);
            return;
        }
        visited[cnt] = true;
        subSet(cnt + 1);
        visited[cnt] = false;
        subSet(cnt + 1);


    }


    public static class Meet {
        int end, cost;

        public Meet(int end, int cost) {
            this.end = end;
            this.cost = cost;
        }


    }
}
