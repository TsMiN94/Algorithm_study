package SWEA;

import java.util.Scanner;

public class Flatten {
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);


        for (int test_case = 1; test_case <= 10; test_case++) {
            int N = sc.nextInt();
            int arr[] = new int[100];

            for (int i = 0; i < 100; i++) {
                arr[i] = sc.nextInt();
            }
            dump(0, arr, N);
            System.out.println("#" + test_case + " " + answer);
        }

    }

    private static void dump(int idx, int[] arr, int N) {

        int max = 0, min = 101;
        int maxIdx = 0, minIdx = 0;

        if (idx == N) {
            for (int i = 0; i < 100; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
                if (arr[i] < min){
                    min = arr[i];
                    minIdx = i;
                }
            }

            //System.out.println(maxIdx +" ," + minIdx);
            answer = arr[maxIdx] - arr[minIdx];
        } else {
            for (int i = 0; i < 100; i++) {
                if (arr[i] > max) {
                    max = arr[i];
                    maxIdx = i;
                }
                if (arr[i] < min){
                    min = arr[i];
                    minIdx = i;
                }
            }

            arr[maxIdx]--;
            arr[minIdx]++;
            dump(idx + 1, arr, N);

        }

    }
}
