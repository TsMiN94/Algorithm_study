package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BJ2491 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int temp = 0;
        int comp = 0;
        int answer = Integer.MIN_VALUE;
        int curValue = 0;
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(st.nextToken());
            if (i == 0) {
                curValue = x;
                temp++;
                continue;
            }


            if (temp > 1) {
                int curComp;
                if (curValue < x) {
                    curComp = 1;
                } else if (curValue > x) {
                    curComp = -1;
                } else {
                    curComp = 0;
                }
                if (curComp == 0 || comp == curComp) {
                    temp++;
                } else {
                    answer = Math.max(answer, temp);
                    temp = 1;
                }

            } else {
                temp++;
            }

            if (curValue < x) {
                comp = 1;
            } else if (curValue > x) {
                comp = -1;
            } else {
                comp = 0;
            }

        }

        System.out.println(answer);


    }
}
