package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1644 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        if (N == 1) {
            System.out.println(0);
        } else {
            List<Integer> list = new ArrayList<>();
            for (int i = 2; i <= N; i++) {
                if (isPrime(i)) list.add(i);
            }
            System.out.println(list);
            int s = 0, e = 0;
            int sum = 0;
            while (true) {

                if (sum >= N) {
                    sum -= list.get(s++);
                } else if (e == list.size()) {
                    break;
                } else sum += list.get(e++);

                if (sum == N) {
                    answer++;
                }
            }
            System.out.println(answer);
        }
    }

    public static boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

}