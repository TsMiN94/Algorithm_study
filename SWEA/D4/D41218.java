package com.ssafy.java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Stack;

public class SWEA1218 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int test_case = 1; test_case <= 10; test_case++) {
            int len = Integer.parseInt(br.readLine());
            String str = br.readLine();

            Stack<Character> s = new Stack<>();
            for (int i = 0; i < len; i++) {

                char c = str.charAt(i);
                if (c == '{' || c == '(' || c == '<' || c == '[') {
                    s.add(c);
                } else if (s.peek() == '(' && c == ')') s.pop();
                else if (s.peek() == '[' && c == ']') s.pop();
                else if (s.peek() == '{' && c == '}') s.pop();
                else if (s.peek() == '<' && c == '>') s.pop();
                else s.push(c);
            }
            if (s.isEmpty()) {
                System.out.println("#" + test_case + " " + 1);
            } else {
                System.out.println("#" + test_case + " " + 0);
            }
        }

    }
}

