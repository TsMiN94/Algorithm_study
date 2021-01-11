package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ11047 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int arr[] = new int[N];
        String str;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        int idx = Arrays.binarySearch(arr, M);
        if (idx < 0) {
            idx *= -1;
            idx -= 2;

            for (int i = idx; i >= 0; i--) {
                while (M >= arr[i]) {
                    M -= arr[i];
                    answer++;
                }
                if (M == 0) {
                    break;
                }

            }
            System.out.println(answer);
        } else {
            System.out.println(1);
        }


    }
}
