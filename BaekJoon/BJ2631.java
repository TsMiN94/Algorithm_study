package BackJun;

import java.util.Arrays;
import java.util.Scanner;

public class BJ2631 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        int LIS[] = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

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
        int answer = 0;
        System.out.println(Arrays.toString(LIS));
        Arrays.sort(LIS);
        answer = N - LIS[N - 1];
        System.out.println(answer);
    }
}
