package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BJ11053 {
    static int LIS[];
    static int arr[];
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        LIS = new int[N];
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if (LIS[i] < LIS[j] + 1) {
                        LIS[i] = LIS[j] + 1;
                    }
                }
            }
        }

        Arrays.sort(LIS);
        System.out.println(LIS[N - 1]);
    }


    public static void setLIS() {
        for (int i = 0; i < N; i++) {
            LIS[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    if(LIS[i] < LIS[j] +1)
                        LIS[i]= LIS[j]+1;
                }
            }
        }
    }
}
