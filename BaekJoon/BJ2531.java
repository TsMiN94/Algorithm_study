package BackJun;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
import java.io.IOException;

public class BJ2531 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;
    static int k, d, c;
    static int arr[];

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        arr = new int[N + k];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        for (int i = N; i < N + k; i++) {
            arr[i] = arr[i - N];
        }
        System.out.println(Arrays.toString(arr));
        HashMap<Integer, Integer> map = new HashMap<>();

        int max = 0;
        int startIdx = 0;
        int endIdx = 0;
        while (endIdx < N + k) {
            if (endIdx - startIdx < k) {
                System.out.println("endIdx ++ and put value = " + arr[endIdx]);
                Integer temp = map.get(arr[endIdx]);
                if (temp == null) {
                    map.put(arr[endIdx++], 1);
                } else {
                    map.put(arr[endIdx++], temp + 1);
                }
            } else {

                if (max <= map.size()) {
                    max = map.size();
                    Integer temp = map.get(c);

                    if (temp == null) {
                        max++;
                    }
                }
                System.out.println(startIdx + "," + endIdx + " map data [" + map.toString() + " ] , max = " + max);
                Integer temp = map.get(arr[startIdx]);
                if (temp == 1) {
                    map.remove((arr[startIdx++]));
                } else {
                    map.put(arr[startIdx++], temp - 1);
                }
            }

        }
        System.out.println(max);
    }
}
