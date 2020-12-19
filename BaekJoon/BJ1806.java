package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1806 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = Integer.MAX_VALUE;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int arr[] = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0, e = 0;
        int sum = 0;
        while (e < N && s <= e) {
            if (sum < M)
                sum += arr[e++];

            if (sum >= M) {
                answer = Math.min(answer, e - s);
                while (s <= e) {
                    sum -= arr[s++];
                    if (sum < M) break;
                    else
                        answer = Math.min(answer, e - s);
                }

            }
        }
        if (answer == Integer.MAX_VALUE) System.out.println(0);
        else
            System.out.println(answer);
    }
}
