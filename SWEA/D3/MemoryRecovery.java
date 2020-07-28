package SWEA;

import java.util.Scanner;

public class MemoryRecovery {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();


        for (int test_case = 1; test_case <= T; test_case++) {
            String str = sc.next();
            char c = '0';
            int cnt = 0;
            for (int i = 0; i < str.length(); i++) {
                if (c != str.charAt(i)) {
                    cnt++;
                    c = str.charAt(i);
                }
            }

            System.out.println("#" + test_case + " " + cnt);

        }
    }
}
