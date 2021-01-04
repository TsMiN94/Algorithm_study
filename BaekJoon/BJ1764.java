package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.io.IOException;

public class BJ1764 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        HashSet<String> hs = new HashSet<>();
        for (int i = 0; i < N; i++) {
            hs.add(br.readLine());
        }
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String s = br.readLine();
            if (hs.contains(s)) {
                list.add(s);
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for(String t :list) System.out.println(t);
    }
}
