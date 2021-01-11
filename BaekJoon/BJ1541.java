package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ1541 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine(),"-");
        List<String> list = new ArrayList<>();
        int size = st.countTokens();
        for (int i = 0; i < size; i++) {
            list.add(st.nextToken());
        }
        for (int i = 0; i < list.size(); i++) {
            String[] s = list.get(i).split("\\+");
            int sum = 0;
            System.out.println(Arrays.toString(s));
            for (int j = 0; j < s.length; j++) {
                sum += Integer.parseInt(s[j]);
            }
            if (i==0) {
                answer += sum;
            } else
                answer -= sum;
        }

        System.out.println(answer);
    }
}
