package BackJun;

import java.util.Scanner;

public class BJ2231 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0; // I  L  l  i
        for (int i = 1; i <= n; i++) {
            int cnt = 0;
            String t = i + "";

            int arr[] = new int[t.length() + 1];
            arr[0] = i;

            int sum = i;
            for (int j = 0; j < t.length(); j++) {
                sum += t.charAt(j) - '0';
            }
            if (sum == n) {
                answer = i;
                break;
            }

        }
        System.out.println(answer);

    }

}
