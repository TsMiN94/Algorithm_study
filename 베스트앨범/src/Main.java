import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};


        int answer[] = Solution.solution(genres, plays);

        for (int i = 0; i < answer.length; i++) {
            System.out.print(answer[i] + " ");
        }
    }

    public static class Solution {
        public static int[] solution(String[] genres, int[] plays) {
            int[] answer = {};
            answer = new int[4];
            int c = 0, p = 0;
            ArrayList<Integer> c_arr = new ArrayList<>();
            ArrayList<Integer> p_arr = new ArrayList<>();
            HashMap<Integer,Integer> h = new HashMap<>();


            for (int i = 0; i < genres.length; i++) {
                h.put(plays[i],i);
                if (genres[i].equals("classic")) {
                    c += plays[i];
                    c_arr.add(plays[i]);
                } else {
                    p += plays[i];
                    p_arr.add(plays[i]);
                }
            }

            Collections.sort(c_arr);
            Collections.sort(p_arr);

            Collections.reverse(c_arr);
            Collections.reverse(p_arr);

            for (int i = 0; i < c_arr.size(); i++) {
                System.out.println(c_arr.get(i));
            }
            if (c > p) {
                for (int i = 0; i < answer.length; i++)
                    if (i < 2)
                        answer[i] = h.get(c_arr.get(i));
                    else
                        answer[i] = h.get(p_arr.get(i - 2));
            } else {
                for (int i = 0; i < answer.length; i++)
                    if (i < 2)
                        answer[i] = h.get(p_arr.get(i));
                    else
                        answer[i] = h.get(c_arr.get(i - 2));
            }


            return answer;
        }
    }
}
