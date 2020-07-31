package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class D41223 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			Queue<Character> numQue = new LinkedList<Character>();
			Stack<Character> opStack = new Stack<Character>();
			Deque<Character> q = new LinkedList<Character>();
			int len = Integer.parseInt(br.readLine());

			String str = br.readLine();

			for (int i = 0; i < len; i++) {
				if (str.charAt(i) == '+' || str.charAt(i) == '-' || str.charAt(i) == '/' || str.charAt(i) == '*')
					opStack.add(str.charAt(i));
				else
					numQue.add(str.charAt(i));

				if (numQue.size() >= 2) {
					q.add(numQue.poll());
					q.add(numQue.poll());
					while (!opStack.isEmpty())
						q.add(opStack.pop());
				}

			}
			while (!numQue.isEmpty())
				q.add(numQue.poll());
			while (!opStack.isEmpty())
				q.add(opStack.pop());

			Stack<Integer> resStack = new Stack<Integer>();
			for (int i = 0; i < len; i++) {
				char first = q.peekFirst();
			
				if (first == '+' || first == '*') {
					opStack.add(q.pollFirst());
					if (resStack.size() >= 2) {
						first = opStack.pop();
						int a = resStack.pop();
						int b = resStack.pop();
						if (first == '+')
							resStack.add((a + b));
						else if (first == '*') {
							resStack.add((a * b));
						} 
					}

				} else {
					resStack.add(q.pollFirst() - '0');
				}
			}
			System.out.println("#"+test_case+ " " +resStack.pop() );
		}
	}
}
