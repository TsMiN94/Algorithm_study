package BackJun;

import java.util.Scanner;

public class BJ1065 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        int answer = 0;
        if (target < 100) {
            System.out.println(target);
        } else {
            answer = 99;
            for (int i = 111; i <= target; i++) {
                String str = i + "";
                int offset;
                int f = str.charAt(0) - '0';
                int s = str.charAt(1) - '0';
                offset = f - s;
                for (int j = 1; j < str.length() - 1; j++) {
                    f = str.charAt(j) - '0';
                    s = str.charAt(j + 1) - '0';
                    if (offset == f - s) {
                        System.out.println(str);
                        answer++;
                    }
                }
            }
            System.out.println(answer);
        }
    }
}