package VCNC;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class No2 {
    public static void main(String[] args) {
        Solution s = new Solution();
        int nat[][] = {{1, 2}, {2, 3}, {1, 3}
        };
        int nat2[][] = {{1, 2}, {2, 3}
        };
        int nat3[][] = {
                {1,2},{2,3},{4,5},{6,7}
        };
        int nat4 [][] ={
                {1,2}
        };
        System.out.println(s.solution(7, nat4));
    }

    static class Solution {
        int arr[];
        int src[] = new int[2];
        int sum = 0;

        public int solution(int n, int nationallity[][]) {
            int answer = 0;
            HashMap<Integer, Character> map = new HashMap<>();
            char c = 'A';
            HashMap<Character, Integer> nationalKind = new HashMap<>();
            nationalKind.put('A', 0);
            boolean[] student = new boolean[n + 1];
            for (int i = 0; i < nationallity.length; i++) {
                boolean isUsed = false;
                int t = 0;
                for (int j = 0; j < 2; j++) {
                    if (map.containsKey((Object) nationallity[i][j])) {
                        t = nationallity[i][j];
                        isUsed = true;
                        break;
                    }
                }
                if (isUsed) {
                    char oldC = map.get((Object) t);
                    int cnt = nationalKind.get(oldC);
                    for (int j = 0; j < 2; j++) {
                        if (!map.containsKey(nationallity[i][j])) {
                            map.put(nationallity[i][j], oldC);
                            nationalKind.put(oldC, ++cnt);
                            student[nationallity[i][j]] = true;
                        }
                    }
                } else {
                    int cnt = 1;
                    for (int j = 0; j < 2; j++) {
                        map.put(nationallity[i][j], c);
                        student[nationallity[i][j]] = true;
                        nationalKind.put(c, cnt++);
                    }
                    c++;
                }
                System.out.println("c= "+c);
                System.out.println("student map " + map);
                System.out.println("national Kind = "+nationalKind);
            }
            System.out.println(Arrays.toString(student));
            for (int i = 1; i < n + 1; i++) {
                if (!student[i]) {
                    nationalKind.put(c++, 1);
                }
            }
            arr = new int[nationalKind.keySet().size()];
            Set<Character> keySet = nationalKind.keySet();
            Iterator<Character> it = keySet.iterator();
            for (int i = 0; i < keySet.size(); i++) {
                arr[i] = nationalKind.get(it.next());
            }
            System.out.println(nationalKind);
            System.out.println(Arrays.toString(arr));
            comb(0, 0);
            answer = sum;
            return answer;
        }

        private void comb(int cnt, int start) {
            if (cnt == 2) {
                sum += (src[0] * src[1]);
                return;
            }
            for (int i = start; i < arr.length; i++) {
                src[cnt] = arr[i];
                comb(cnt + 1, i + 1);
            }
        }
    }

}
