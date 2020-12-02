package SWEA;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution_모의SW역량테스트_보물상자 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int answer = 0;
    static int N, K;
    static String[] numbersArr = new String[4];
    static Set<Integer> set;

    public static void main(String[] args) throws IOException {


        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {
            set = new HashSet<>();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());
            String numbers = br.readLine();
            int offset = numbers.length() / 4;
            for (int k = 0; k < offset; k++) {

                for (int i = 0; i < 4; i++) {
                    StringBuilder sb = new StringBuilder();
                    String temp = numbers.substring(i * offset, (i + 1) * offset);
                    for (int j = 0; j < offset; j++) {
                        sb.append(temp.charAt(j));
                    }
                    numbersArr[i] = sb.toString();
                }
                for (int i = 0; i < 4; i++) {
                    int sum = 0;
                    int cnt = 0;
                    for (int j = offset - 1; j >= 0; j--) {
                        int asc = (int) numbersArr[i].charAt(j);
                        if (asc >= 65 && asc <= 70) {
                            asc -= 55;
                        } else {
                            asc = numbersArr[i].charAt(j) - '0';
                        }
                        sum += asc * (int) Math.pow(16, cnt);
                        cnt++;
                    }
                    set.add(sum);
                }
                String temp = numbers.substring(1, numbers.length());
                temp += numbers.charAt(0);
                numbers = temp;
            }

            Iterator<Integer> it = set.iterator();
            ArrayList<Integer> list = new ArrayList<>();
            while (it.hasNext()) {

                list.add(it.next());
            }
            Collections.sort(list, Collections.reverseOrder());

            System.out.println("#" + (t + 1) + " " + list.get(K - 1));
        }
    }
}
