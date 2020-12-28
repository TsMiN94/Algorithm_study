package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ3020 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, H;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());
        List<Integer> sum = new ArrayList<Integer>();
        int[] a = new int[H+1];
        int[] b = new int[H+1];

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            if (i % 2 == 0)
                a[n]++;
            else
                b[n]++;
        }


        for (int i = H; i >= 2; i--) {
            a[i - 1] += a[i];
            b[i - 1] += b[i];
        }


        for (int i = 1; i <= H; i++) {
            int x = a[i];
            int y = b[H + 1 - i];
            sum.add(x + y);
        }
        Collections.sort(sum);
        int cnt=0;
        for(int k=0;k<sum.size();k++) {
            if(sum.get(k).equals(sum.get(0)))
                cnt++;
            else
                break;
        }
        System.out.println(sum.get(0)+" "+cnt);
    }
}
