package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ11054 {
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
                if (arr[i] > arr[j] && LIS[i] < LIS[j] + 1) {
                    LIS[i] = LIS[j] + 1;
                }
            }
        }

        //뒤에서부터 인덱스를 반대 방향으로 증가하는 부분수열 LIS 배열 값 갱신
        for (int i = N - 1; i >= 0; i--) {
            rLIS[i] = 1;
            for (int j = N - 1; j > i; j--) {
                if (arr[i] > arr[j] && rLIS[i] < rLIS[j] + 1) {
                    rLIS[i] = rLIS[j] + 1;
                }
            }
        }

        //arr  1 3 2 4 1 2
        //LIS  1 2 2 3 1 2
        //rLIS 1 3 2 2 1 1
        //다시 앞에서부터 돌면서 i 보다 커졌을때는 rLIS의 값을 LIS에더해준다
        for (int i = 0; i < N; i++) {
            LIS[i] +=rLIS[i] -1;
        }

        System.out.println(Arrays.toString(LIS));
        Arrays.sort(LIS);
        System.out.println(LIS[N-1]);
    }
}