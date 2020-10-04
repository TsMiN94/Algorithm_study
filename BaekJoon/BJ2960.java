package BackJun;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BJ2960 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int answer = 0;
        int arr[] = new int[N + 1];
        arr[0] = 0;
        arr[1] = 0;
        for (int i = 2, num = 2; i <= N; i++, num++) {
            arr[i] = num;
        }
        int cnt = 0;
        int idx = 1;
        while (cnt != K) {
            if (arr[idx] > 0 && isPrime(arr[idx])) {
                int m = 1;
                int min = idx * m;
                while (min <= N) {
                    cnt++;
                    if (cnt == K) {
                        answer = arr[min];
                        break;
                    }
                    arr[min] = 0;
                    min = idx * ++m;
                    while (min<=N&&arr[min] == 0) {
                        min = idx * ++m;
                    }
                }
            }
            idx++;
        }
        System.out.println(answer);
    }

    private static boolean isPrime(int n) {
        int p = 0;
        if (n == 2) return true;
        for (int i = 3; i < Math.sqrt(n); i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;


    }
}
