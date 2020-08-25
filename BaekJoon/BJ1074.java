package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BJ1074 {

    static int N, r, c;
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int len = (int) Math.pow(2, N);

        divide(0, 0, len);
    }

    private static void divide(int sx, int sy, int mid) {

        if (mid == 1) {
            if (sx == r && sy == c)
                System.out.println(answer);
            answer++;
            return;
        }
        mid = mid / 2;
        divide(sx, sy, mid);
        divide(sx, sy + mid, mid);
        divide(sx + mid, sy, mid);
        divide(sx + mid, sy + mid, mid);


    }
}
