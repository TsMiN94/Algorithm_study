package com.ssafy.algo;

import java.util.Arrays;
import java.util.Comparator;

public class MaxNumber {
	public static void main(String[] args) {
		Solution s = new Solution();
		int arr[] = { 3, 30, 34, 5, 9 };

		System.out.println(s.solution(arr));
	}

	public static class Solution {

		public String solution(int[] arr) {
			StringBuilder sb = new StringBuilder();

			String str[] = new String[arr.length];
			for (int i = 0; i < arr.length; i++) {
				str[i] = String.valueOf(arr[i]);
			}
			Arrays.sort(str, new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					// TODO Auto-generated method stub
					return (o2+o1).compareTo(o1+o2);
				}
			});
			
			if (str[0] == "0")
				return "0";
			
			for (int i = 0; i < str.length; i++)
				sb.append(str[i]);

			return sb.toString();
		}

	}
}
