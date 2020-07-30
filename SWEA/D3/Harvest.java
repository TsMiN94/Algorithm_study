package com.ssafy.algo.swea;

import java.util.Scanner;

public class Harvest {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= 5; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];

			for (int i = 0; i < N; i++) {
				String data = sc.next();
				for (int j = 0; j < data.length(); j++) {
					arr[i][j] = data.charAt(j)-'0';
				}
			}
			
//			for(int i =0 ; i < N ; i++) {
//				for(int j = 0 ; j< N; j++) {
//					System.out.print(arr[i][j] +" ");
//				}
//				System.out.println();
//			}
			

			System.out.println("#"+test_case + " " +harvest(arr));

		}
	}

	private static int harvest(int[][] arr) {
		int offset = arr.length / 2;
		int sum = 0;

		for (int i = 0; i < arr.length / 2; i++) {
			for (int j = offset; j < arr.length; j++) {
				if (arr.length - j == offset) {
					offset--;
					break;
				}
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
		offset = arr.length / 2;
		for (int i = arr.length - 1; i > arr.length / 2; i--) {
			for (int j = offset; j < arr.length; j++) {
				if (arr.length - j == offset) {
					offset--;
					break;
				}
				sum += arr[i][j];
			}
		}
		
		System.out.println(sum);
		for(int i = 0 ; i < arr.length ; i++) {
			sum+= arr[arr.length/2][i] ;
		}
		
		System.out.println(sum);		
		return sum;

	}

}
