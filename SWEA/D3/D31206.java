package com.ssafy.algo.swea;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class D31206 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = 10;
		int arr[] = new int[1000];
		
		for (int test_case = 1; test_case <= T; test_case++) {
			int answer = 0;
			StringTokenizer st = new StringTokenizer(br.readLine());
			int b = Integer.parseInt(st.nextToken());
		
			int maxH = 0, maxHindex = 0;
			st = new StringTokenizer(br.readLine());

			for (int i = 0; i < b; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			
				if (maxH < arr[i]) {
					maxH = arr[i];
					maxHindex = i;
				}
				if (i > 3) {
					Integer temp[] = new Integer[5];
					for (int j = i, cnt = 0; j >=i-4; j--, cnt++) 
						temp[cnt] = arr[j];
				
					
					Arrays.sort(temp, Comparator.reverseOrder());
					// 가장 큰값이 나라면
					if (temp[0] == arr[i - 2]) {
						answer += temp[0] - temp[1];
					
					}
				}
			}
			System.out.println("#" + test_case + " " + answer);
		}

	}
}
