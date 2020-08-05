package com.programmers.algo;

public class KakaoMaxOp {
	public static void main(String[] args) {

	}

	static class Solution {

		static char mul = '*';
		static char min = '-';
		static char plus = '+';
		static boolean[] op = new boolean[3];
		static char[] opSrc;
		static char[] opArr;
		static String str;
		static int r = 0;

		public long solution(String expression) {
			long answer = 0;
			str = expression;
			if (expression.contains(mul + "")) {
				op[0] = true;
				r++;
			}
			if (expression.contains(min + "")) {
				op[1] = true;
				r++;
			}
			if (expression.contains(plus + "")) {
				op[2] = true;
				r++;
			}
			opSrc = new char[r];
			opArr = new char[r];
			perm(0, new boolean[r]);
			return answer;
		}

		public void perm(int cnt, boolean[] visited) {
			if (cnt == r) {
				StringBuilder sb = new StringBuilder();
				for (int i = 0; i < opArr.length; i++) {
					char priorityOp = opArr[i];
					while (str.indexOf(priorityOp) != -1) {
						int index = str.indexOf(priorityOp);
						
					}
				}
			}
			for (int i = 0; i < opArr.length; i++) {
				if (!visited[cnt]) {
					visited[cnt] = true;
					opArr[cnt] = opSrc[i];
					perm(cnt + 1, visited);
					visited[cnt] = false;

				}
			}
		}
	}

}
