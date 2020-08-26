package BackJun;

import java.util.Scanner;

public class BJ7568 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x[] = new int[N];
        int y[] = new int[N];
        int answer[] = new int[N];
        for (int i = 0; i < N; i++) {
            x[i] = sc.nextInt();
            y[i] = sc.nextInt();
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;

                if (x[i] < x[j] && y[i] < y[j]) {
                    answer[i]++;
                }
            }
        }
        for (int i = 0; i < N; i++)
            System.out.print((answer[i] + 1) + " ");
    }
}
