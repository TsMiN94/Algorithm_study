package BackJun;

import org.w3c.dom.ls.LSInput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BJ1759 {
    static int N, R;
    static char arr[], src[];
    static int pArr[];
    static int answer = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        src = new char[N];
        arr = new char[R];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            src[i] = st.nextToken().charAt(0);
        Arrays.sort(src);
        findPwd(0, 0, 0, 0);
    }

    private static void findPwd(int cnt, int start, int a, int b) {
        if (cnt == R) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++)
                sb.append(arr[i]);
            if (a >= 2 && b >= 1)
                System.out.println(sb.toString());
            return;
        }
        for (int i = start; i < src.length; i++) {
            arr[cnt] = src[i];
            char t = src[i];
            if (t == 'a' || t == 'e' || t == 'i' || t == 'o' || t == 'u') {
                findPwd(cnt + 1, i + 1, a, b + 1);
            } else {
                findPwd(cnt + 1, i + 1, a + 1, b);
            }
        }
    }


}
