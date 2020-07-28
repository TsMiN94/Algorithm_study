package SWEA;

import java.util.Scanner;

public class Hamburger {
    static int answer;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

        for (int test_case = 1; test_case <= T; test_case++) {

            int N = sc.nextInt();
            int L = sc.nextInt();
            int arr[][] = new int[N][2];
            for (int i = 0; i < N; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }


            dfs(arr, L, 0, 0 , 0);

            System.out.println("#"+test_case + " "+answer);
            answer= 0;
        }


    }

    private static void dfs(int[][] arr, int L, int point, int currentCal,int idx) {
        if (currentCal > L) {
            return;
        }
        if(idx == arr.length){
            answer= Math.max(answer , point);
            return;
        }


        dfs(arr, L, point + arr[idx][0], currentCal + arr[idx][1], idx + 1);
        dfs(arr , L , point ,currentCal ,idx+1  );

    }
}
