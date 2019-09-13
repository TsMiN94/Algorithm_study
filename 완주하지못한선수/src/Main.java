import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String part[] = {"mislav","stanko", "mislav", "ana"};
        String comp[] = {"stanko", "mislav", "ana"};

        System.out.println(Solution.solution(part,comp));
    }


    public static class Solution {
        public static String solution(String[] participant, String[] completion) {
            String answer = "";
            Arrays.sort(participant);
            Arrays.sort(completion);
            int i ;
            for(i = 0 ; i <completion.length ;i++) {
                if (!participant[i].equals(completion[i]))
                    return participant[i];
            }
            return participant[i];
        }
    }
}
