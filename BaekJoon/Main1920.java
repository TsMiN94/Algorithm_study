package BackJun;

import java.util.*;

public class Main1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N, M;
        boolean flag= false;
        N = sc.nextInt();
        int nArr[] = new int[N];
        for (int i = 0; i < N; i++)
            nArr[i] = sc.nextInt();

        M = sc.nextInt();
        int mArr[] = new int[M];
        for (int i = 0; i < M; i++)
            mArr[i] = sc.nextInt();

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (nArr[j] == mArr[i]) {
                    System.out.println("1");
                    flag =true;
                    break;
                }
            }
            if(!flag)
                System.out.println("0");
            flag = false;
        }

    }

}

