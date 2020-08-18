package BackJun;

import java.util.Scanner;

public class No2003 {
    public static void main(String[] args) {
        int answer = 0;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int sumArr[] = new int[n];
        int arr[] = new int[n];
        int idx = 0;
        sumArr[idx] = 0;


        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int sum =0;
        for (int i = 0; i < n; i++) {
            while(sum < m && idx <n){
                sum +=arr[idx];
                idx++;
            }
            if(sum == m) answer++;
            sum -=arr[i];
        }
        System.out.println(answer);

    }

}

