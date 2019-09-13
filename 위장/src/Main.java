import java.util.*;

public class Main {
    public static void main(String[] args) {
        String clothes[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        System.out.println(Solution.solution(clothes));

    }

    public static class Solution {
        public static int solution(String[][] clothes) {
            int answer = 1;
            HashMap<String, Integer> h = new HashMap<>();

            for (int i = 0; i < clothes.length; i++) {
                String type = clothes[i][1];
                if (h.containsKey(type)) {
                    h.put(type, h.get(type) + 1);
                } else
                    h.put(type, 2);
            }


            Set<String> keys = h.keySet();
            Iterator<String> it = keys.iterator();
            while (it.hasNext()) {
                String key = it.next();
                System.out.println(key);
                System.out.println(h.get(key));
                answer *= h.get(key);
            }

            return answer-1;
        }
    }


}
