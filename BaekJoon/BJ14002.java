package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ14002 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];
        int LIS[] = new int[N];
        int answer[] = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //앞에서부터 증가하는 부분수열 LIS 배열 값 갱신
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            answer[i] = arr[i];

            int max = arr[i];
            for (int j = 0; j < i; j++) {
                int sum = arr[i];
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                    sum += answer[j];
                }
                if (sum > max)
                    max = sum;
            }
            answer[i] = max;
        }


        System.out.println(Arrays.toString(answer));
        Arrays.sort(answer);
        System.out.println(answer[N - 1]);
    }
}
