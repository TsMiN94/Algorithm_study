package SWEA_D3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class SpotMart {
    static int arr[];
    static int w, answer = -1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = sc.nextInt();
            w = sc.nextInt();
            int snackArr[] = new int[N];
            arr = new int[2];
            answer = -1;
            for (int i = 0; i < N; i++) {
                snackArr[i] = sc.nextInt();
            }
            calc(snackArr, 0, 0);

            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void calc(int[] snackArr, int cnt, int start) {
        if (cnt == 2) {
            int sum = 0;
            for (int i = 0; i < arr.length; i++)
                sum += arr[i];
            if (sum <= w) {
                answer = Math.max(sum, answer);
            }
            return;
        }
        for (int i = start; i < snackArr.length; i++) {

            arr[cnt] = snackArr[i];
            calc(snackArr, cnt + 1, i + 1);
        }

    }
}
