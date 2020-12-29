package BackJun;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class BJ1339 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, M;

    static boolean[] used = new boolean[10];
    static int[] numbers = new int[10];

    static String[] words;
    static int total = 0;

    static List<Character> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
            for (int j = 0; j < words[i].length(); j++) {
                if (!list.contains(words[i].charAt(j))) {
                    list.add(words[i].charAt(j));
                }
            }
        }

        numbers = new int[list.size()];
        total = list.size();

        find(0);
        System.out.println(answer);
    }

    private static void find(int cnt) {
        if (cnt == total) {
            int sum = 0;
            for (int i = 0; i < N; i++) {
                int num = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    num *= 10;
                    num += numbers[list.indexOf(words[i].charAt(j))];
                }
                sum += num;
            }
            answer = Math.max(sum, answer);
            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!used[i]) {
                used[i] = true;
                numbers[cnt] = i;
                find(cnt + 1);
                numbers[cnt] = 0;
                used[i] = false;
            }
        }

    }
}
