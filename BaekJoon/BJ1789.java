package backjun;

import java.util.Scanner;

public class BJ1789 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long S = sc.nextInt();
		long sum =0;
		long a= 0;
		while(sum<S) {
			sum+=++a;
		}
	
		if(sum==S)System.out.println(a);
		else
			System.out.println(a-1);
		
	}
}
