import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String phone_book[] = {"123", "456", "789"};
        System.out.println(Solution.solution(phone_book));


    }

    public static class Solution {
        public static boolean solution(String[] phone_book) {
            boolean answer = true;
            Arrays.sort(phone_book);
            for (int i = 0; i < phone_book.length - 1; i++) {
                for (int j = i + 1; j < phone_book.length; j++) {
                   if(phone_book[i].startsWith(phone_book[j]))
                       return false;
                   if (phone_book[j].startsWith(phone_book[i]))
                        return false;
//                    String tmp = phone_book[j].substring(0, phone_book[i].length());
  //                  if (phone_book[i].equals(tmp))
    //                    return false;
                }
            }

            return true;
        }
    }
}
