package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ18513 {

    static int N, K;

    static int[] chicken;
    static boolean[] map = new boolean[200000000 + 200000];

    static long answer = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        chicken = new int[N];

        st = new StringTokenizer(br.readLine());


        for (int i = 0; i < N; i++) {
            chicken[i] = Integer.parseInt(st.nextToken());
            map[chicken[i] + 100000000] = true;
        }

        Arrays.sort(chicken);

        int cnt = 0;
        int index = 0;
        int dist = 1;

        while (true) {
            int leftIndex = chicken[index] + 100000000 - dist;
            int rightIndex = chicken[index] + 100000000 + dist;

            if (leftIndex >= 0 && !map[leftIndex]) {
                map[leftIndex] = true;
                cnt++;
                answer += dist;
                if (cnt == K) break;
            }

            if (rightIndex < 200200000 && !map[rightIndex]) {
                map[rightIndex] = true;
                cnt++;
                answer += dist;
                if (cnt == K) break;
            }
            index++;
            if (index == N) {
                dist++;
            }
            index %= N;
        }
        System.out.println(answer);

    }
}
