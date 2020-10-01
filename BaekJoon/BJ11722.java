package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11722 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int LIS[] = new int[N];
        int rLIS[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //앞에서부터 증가하는 부분수열 LIS 배열 값 갱신
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }


        Arrays.sort(LIS);
        System.out.println(LIS[N-1]);
    }
}