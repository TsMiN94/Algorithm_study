package BackJun;

import java.io.*;
import java.util.*;

public class BJ15663 {
    static int src[];
    static int arr[];
    static int N, M;
    static boolean visited[];
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static LinkedHashSet<String> hashSet = new LinkedHashSet<String>();


    public static void main(String[] args) throws IOException {

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        src = new int[N];
        arr = new int[M];
        visited = new boolean[N];
        st = new StringTokenizer(br.readLine());
        Set<Integer> s = new HashSet<>();
        for (int i = 0; i < N; i++) {
            src[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(src);
        perm(0);
       for(String str : hashSet)
           System.out.println(str);

    }

    private static void perm(int cnt) throws IOException {
        if (cnt == M) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]+" ");
            }
            String temp = sb.toString();

            hashSet.add(temp.trim());
            return;
        }
        for (int i = 0; i < src.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                arr[cnt] = src[i];
                perm(cnt + 1);
                visited[i] = false;
            }
        }


    }
}
