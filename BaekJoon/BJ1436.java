package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ1436 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int num = 666;
        while (cnt != N) {
            num++;
            if (String.valueOf((num)).contains("666")) cnt++;
        }
        System.out.println(num);
    }
}
