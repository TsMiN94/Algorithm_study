package Kakao2020Blind;

import java.util.Stack;

public class StringChange {
    public static void main(String[] args) {

    }

    static class Solution {
        int balncedIdx;

        public String solution(String p) {
            if (p.isEmpty()) return p;

            boolean balance = isBalance(p);

            String u = p.substring(0, balncedIdx + 1);
            String v = p.substring(balncedIdx + 1, p.length());

            if (balance) {
                return u + solution(v);
            }

            String emptyStr = "(" + solution(v) + ")";

            for (int i = 1; i < u.length() - 1; i++) {
                if (u.charAt(i) == '(')
                    emptyStr += ")";
                else
                    emptyStr += "(";
            }


            return emptyStr;
        }

        public boolean isBalance(String s) {
            boolean check = true;
            Stack<Character> stack = new Stack<>();
            int open = 0, close = 0;

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '(') {
                    open++;
                    stack.push(s.charAt(i));
                } else {
                    close++;
                    if (stack.isEmpty()) {
                        check = false;
                    } else
                        stack.pop();
                }

                if (open == close) {
                    balncedIdx = i;
                    return check;
                }
            }
            return check;
        }


    }
}
