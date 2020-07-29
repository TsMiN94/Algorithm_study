package com.ssafy.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class Gem {

	public static void main(String[] args) {
		//String gems[] = { "DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA" };
		//String gems[] = { "AA", "AB", "AC", "AA", "AC" };
		String gems[] = { "XYZ", "XYZ", "XYZ" };
		// String gems[] = {"ZZZ", "YYY", "NNNN", "YYY", "BBB"};
		System.out.println(Arrays.toString(new Solution().solution(gems)));
	}

	static class Solution {
		public int[] solution(String[] gems) {
			int[] answer = { Integer.MAX_VALUE, Integer.MAX_VALUE };
			int len = Integer.MAX_VALUE;
			int start = 0, end = 0, startPoint=0;
			HashSet<String> set = new HashSet<String>();

			Queue<String> q = new LinkedList<String>();
			HashMap<String, Integer> hm = new HashMap<String, Integer>();

			for (int i = 0; i < gems.length; i++)
				set.add(gems[i]);

			if (set.size() == 1)
				return new int[] { 1, 1 };

			for (int i = 0; i < gems.length; i++) {

				if (!hm.containsKey(gems[i]))
					hm.put(gems[i], 1);
				else
					hm.put(gems[i], hm.get(gems[i]) + 1);

				q.add(gems[i]);
				while(true) {
	        		String temp = q.peek();
	        		if(hm.get(temp) > 1) {
	        			hm.put(temp, hm.get(temp) - 1);
	        			q.poll();
	        			startPoint++;
	        		}
	        		else {
	        			break;
	        		}
	        	}
	        	if(hm.size() == set.size() && len > q.size()) {
	        		len = q.size();
	        		start = startPoint;
	        	}

			}
			return new int[] { start + 1, start + len };
		}
	}

}
